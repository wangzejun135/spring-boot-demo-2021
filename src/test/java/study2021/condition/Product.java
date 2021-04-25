package study2021.condition;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Describe 生产者
 * @Author wangzejun
 * @Date 2021/3/20 10:06
 */
public class Product implements Runnable {
    private Queue<String> msg;
    private int maxSize;
    private Lock lock;
    private Condition condition;


    public Product(Queue<String> msg, int maxSize, Lock lock, Condition condition) {
        this.msg = msg;
        this.maxSize = maxSize;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        // 获得当前线程的名称
        System.out.println(Thread.currentThread().getName());
        int a = 0;
        while (true) {
            a++;
            lock.lock();
            while (msg.size() == maxSize) {
                System.out.println("生产者队列满了，先等待");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产者生产消息：" + a);
            msg.add("我是生产者" + a);
            // 唤醒处于阻塞状态下的线程
            condition.signal();
            // 释放锁
            lock.unlock();
        }
    }
}
