/*
 * 文 件 名:  ConcurrentController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright 2005-2008,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  j65521
 * 修改时间:  2008-3-28
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.example.springbootdemo2021.util;

import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

/**
 * 并发控制器 统计并限制并发请求
 * 
 * @author j65521
 * @version [版本号, 2012-2-28]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ConcurrentController
{
    /**
     * 不限制并发请求数
     */
    public static final int NO_LIMIT = -1;

    /**
     * 一直等待
     */
    public static final int ALWAYS_WAIT = -1;

    /**
     * 不等待
     */
    public static final int NO_WAIT = 0;

    /**
     * 当前的并发请求计数
     */
    private volatile int current = 0;

    /**
     * 限制并发请求计数
     */
    private volatile int limit;

    /**
     * 最大的并发请求数
     */
    private volatile int max = 0;

    /**
     * 累计请求数
     */
    private volatile int total = 0;

    /**
     * 同步锁
     */
    private Object lock = new Object();

    /**
     * 唤醒线程
     */
    private WakeupThread wakeupThread = new WakeupThread();

    /**
     * 并发线程map
     */
    private Map<Thread, Entry> concurrentMap = new Hashtable<Thread, Entry>(128);

    /**
     * 计算TPS
     */
    private TPSController tpsController = null;

    /**
     * 父并发控制器
     */
    private ConcurrentController parent = null;

    /**
     * 等待队列
     */
    private LinkedList<Entry> queue = new LinkedList<Entry>();

    /**
     * 最大并发数变更时间
     */
    private Date maxConcurrentChangeTime = new Date();

    /**
     * 构造函数
     */
    public ConcurrentController()
    {
        this(NO_LIMIT, null);
    }

    /**
     * 构造函数
     * 
     * @param limit
     *            限制的并发请求数
     */
    public ConcurrentController(int limit)
    {
        this(limit, null);
    }

    /**
     * 构造函数
     * 
     * @param limit
     *            限制的并发请求数
     * @param parent
     *            TPS计算器
     */
    public ConcurrentController(int limit, ConcurrentController parent)
    {
        this.current = 0;
        this.max = 0;
        this.limit = limit;
        this.parent = parent;

        wakeupThread.start();
    }

    /**
     * 开始请求事务 如果事务达到限制线程将等待，直到有事务被释放， 使用<tt>beginTransaction(long time)</tt>限制等待时间
     * 
     * @author mWX177641
     * @return 事务是否请求成功
     * @throws InterruptedException
     *             被打断异常
     */
    public boolean beginTransaction() throws InterruptedException
    {
        return beginTransaction(ALWAYS_WAIT);
    }

    /**
     * 开始一个事务 当事务达到限制线程将等待指定的时间； 如果在时间内有事务被释放，方法返回<tt>true</tt>，否则返回<tt>false</tt> 等待时间为<tt>-1</tt>时，表示一直等待，同
     * <tt>beginTransaction()</tt>方法
     * 
     * @author mWX177641
     * @param time
     *            事务时间
     * @return 事务是否请求成功
     * @throws InterruptedException
     *             被打断异常
     */
    public boolean beginTransaction(long time) throws InterruptedException
    {
        Entry entry = new Entry(Thread.currentThread());

        if (null != parent)
        {
            // 有父控制器，首先获取父控制器事务
            long curtime = System.currentTimeMillis();

            boolean result = parent.beginTransaction(time);

            if (result)
            {
                curtime = System.currentTimeMillis() - curtime;

                if (time > 0)
                {
                    if (curtime >= time)
                    {
                        time = NO_WAIT;
                    }
                    else
                    {
                        time = time - curtime;
                    }
                }
            }
            else
            {
                return result;
            }
        }

        if (tryIncTransaction(entry))
        {
            return true;
        }

        // 不等待
        if (NO_WAIT == time)
        {
            if (null != parent)
            {
                // 释放父事务
                parent.finishTransactionWithoutTotal(entry.thread);
            }

            return false;
        }

        // 放入等待队列
        synchronized (queue)
        {
            // 放入等待队列
            queue.add(entry);
        }

        synchronized (entry)
        {
            try
            {
                if (time > 0)
                {
                    // 等待指定时间
                    entry.wait(time);

                    // 被唤醒的
                    if (entry.notified)
                    {
                        return true;
                    }
                    else
                    {
                        if (null != parent)
                        {
                            // 释放父事务
                            parent.finishTransactionWithoutTotal(entry.thread);
                        }

                        entry.canceled = true;

                        return false;
                    }
                }
                else
                {
                    while (entry.notified)
                    {
                        entry.wait();
                    }

                    return true;
                }
            }
            finally
            {
                synchronized (queue)
                {
                    // 移出等待队列
                    queue.remove(entry);
                }
            }
        }
    }

    /**
     * 结束请求事务
     * 
     * @author mWX177641
     */
    public void finishTransaction()
    {
        finishTransaction(Thread.currentThread(), true);
    }

    /**
     * 结束请求事务
     * 
     * @author mWX177641
     * @param thread
     *            等待线程
     * @param finishParent
     *            是否结束父进程
     */
    public void finishTransaction(Thread thread, boolean finishParent)
    {
        if (null == thread)
        {
            return;
        }

        synchronized (lock)
        {
//            if(!isTransactionOutOfLimit())
//            {
//                current--;
//            }

            Entry entry = (Entry) concurrentMap.remove(thread);
            if (null == entry)
            {
                return;
            }
            else
            {
                if (entry.isRunning())
                {
                    current--;

                    wakeupThread.wakeup();
                }
            }

        }

        // 结束父事务
        if ((finishParent) && (null != parent))
        {
            parent.finishTransaction(thread, true);
        }
    }

    /**
     * 关闭当前线程中的事务
     * 
     * @author mWX177641
     * @param thread
     *            线程
     */
    private void finishTransactionWithoutTotal(Thread thread)
    {
        finishTransaction(thread, false);

        if (null != parent)
        {
            parent.finishTransactionWithoutTotal(thread);
        }

        synchronized (lock)
        {
            total--;
        }
    }

    /**
     * 请求事务是否超过限制
     * 
     * @author mWX177641
     * @return true：事务超过限制 false：事务没有超过限制
     */
    public boolean isTransactionOutOfLimit()
    {
        return ((limit >= 0) && (current >= limit));
    }

    /**
     * 获取所有当前的并发线程
     * 
     * @author mWX177641
     * @return 当前并发线程集
     */
    public Collection<Entry> getConcurrentThread()
    {
        return concurrentMap.values();
    }

    /**
     * 取得parent
     * 
     * @return 返回parent。
     */
    public ConcurrentController getParent()
    {
        return parent;
    }

    /**
     * 设置parent
     * 
     * @param parent
     *            要设置的parent。
     */
    public void setParent(ConcurrentController parent)
    {
        this.parent = parent;
    }

    /**
     * 获取一个等待的线程
     * 
     * @author mWX177641
     * @return 等待的线程
     */
    private Entry getWaitingEntry()
    {
        return queue.removeFirst();
    }

    /**
     * 增加一个事务
     * 
     * @author mWX177641
     * @param entry
     *            事务
     * @return 是否新增成功
     */
    private boolean tryIncTransaction(Entry entry)
    {
        if (!isTransactionOutOfLimit())
        {
            synchronized (lock)
            {
                if (!isTransactionOutOfLimit())
                {
                    if(concurrentMap.get(entry.thread)!=null)
                    {
                        return true;
                    }
                    current++;
                    total++;

                    if (current > max)
                    {
                        max = current;
                        maxConcurrentChangeTime = new Date();
                    }

                    if (null != tpsController)
                    {
                        tpsController.inc();
                    }

                    entry.running = true;

                    // 放入map
                    concurrentMap.put(entry.thread, entry);

                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 取得current
     * 
     * @return 返回current。
     */
    public int getCurrent()
    {
        return current;
    }

    /**
     * 取得limit
     * 
     * @return 返回limit。
     */
    public int getLimit()
    {
        return limit;
    }

    /**
     * 设置limit
     * 
     * @param limit
     *            要设置的limit。
     */
    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    /**
     * 取得max
     * 
     * @return 返回max。
     */
    public int getMax()
    {
        return max;
    }

    /**
     * 取得tpsController
     * 
     * @return 返回tpsController。
     */
    public TPSController getTpsController()
    {
        return tpsController;
    }

    /**
     * 设置tpsController
     * 
     * @param tpsController
     *            要设置的tpsController。
     */
    public void setTpsController(TPSController tpsController)
    {
        this.tpsController = tpsController;
    }

    /**
     * 等待的线程对象
     * 
     * @author mWX177641
     * @version CMR20 2013-8-27
     * @since V100R001C01LCM020
     */
    public class Entry
    {
        /**
         * 线程信息
         */
        private Thread thread;

        /**
         * 唤醒
         */
        private volatile boolean notified = false;

        /**
         * 事务运行中
         */
        private volatile boolean running = false;

        /**
         * 事务取消
         */
        private volatile boolean canceled = false;

        /**
         * 构造函数 
         * @param thread
         */
        Entry(Thread thread)
        {
            this.thread = thread;
        }

        /**
         * 取得thread
         * 
         * @return 返回thread。
         */
        public Thread getThread()
        {
            return thread;
        }

        /**
         * 取得running
         * 
         * @return 返回running。
         */
        public boolean isRunning()
        {
            return running;
        }
    }

    /**
     * 取得total
     * 
     * @return 返回total。
     */
    public int getTotal()
    {
        return total;
    }

    /**
     * 设置total
     * 
     * @param total
     *            要设置的total。
     */
    public void setTotal(int total)
    {
        this.total = total;
    }

    /**
     * 
     * 唤醒线程
     * 
     * @author j65521
     * @version [版本号, 2008-3-28]
     * @see [相关类/方法]
     * @since [产品/模块版本]
     */
    class WakeupThread extends Thread
    {
        /**
         * 线程中止
         */
        private boolean terminal = false;

        /**
         * 线程运行标志
         */
        private boolean running = true;

        /**
         * 构造函数
         */
        WakeupThread()
        {
            super("ConcurrentController-WakeupThread");
        }

        /**
         * {@inheritDoc}
         */
        public void run()
        {
            while (!terminal)
            {
                if (queue.isEmpty())
                {
                    // 队列空，自动停止
                    synchronized (this)
                    {
                        try
                        {
                            running = false;
                            this.wait();
                        }
                        catch (InterruptedException e)
                        {
                            // do nothing
                        }

                        continue;
                    }
                }

                Entry entry = getWaitingEntry();
                if (null != entry)
                {
                    synchronized (this)
                    {
                        while (isTransactionOutOfLimit())
                        {
                            try
                            {
                                running = false;
                                this.wait();
                            }
                            catch (InterruptedException e)
                            {
                                // do nothing
                            }
                        }
                    }

                    synchronized (entry)
                    {
                        if ((!entry.canceled) && (tryIncTransaction(entry)))
                        {
                            entry.notified = true;

                            entry.notifyAll();
                        }
                    }
                }
            }
        }

        /**
         * 中止线程
         * 
         * @author mWX177641
         */
        void terminal()
        {
            terminal = true;
            wakeup();
        }

        /**
         * 唤醒
         * 
         * @author mWX177641
         */
        void wakeup()
        {
            if (!running)
            {
                synchronized (this)
                {
                    if (!running)
                    {
                        running = true;
                        this.notifyAll();
                    }
                }
            }
        }
    }

    /**
     * 控制器最大并发数max改变时系统时间
     * 
     * @author lKF42842
     * @return 控制器最大并发数max改变时系统时间
     */
    public long getMaxConcurrentChangeTime()
    {
        return maxConcurrentChangeTime.getTime();
    }

    public static void main(String args[])
    {
    }

}
