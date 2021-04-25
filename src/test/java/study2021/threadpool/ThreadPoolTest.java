package study2021.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/25 16:48
 */

public class ThreadPoolTest {
    // 线程池初始化
    public static ThreadPoolExecutor pool = null;

    /**
     * 线程池各个参数定义如下：
     *
     * corePoolSize：核心线程数（5）
     * maxPoolSize：最大线程数（10）
     * keepAliveTime：线程空闲时间（1）
     * unit：空闲时间单位（分钟）
     * queueCapacity：任务队列容量（阻塞队列20）
     * threadFactory：线程工厂使用默认Executors.defaultThreadFactory()
     * handler：拒绝策略使用默认 new AbortPolicy()
     *
     * 四种拒绝策略如下：
     * AbortPolicy：丢弃任务并抛出RejectedExecutionException异常 (默认)
     * DiscardPolicy：也是丢弃任务，但是不抛出异常
     * DiscardOldestPolicy：丢弃队列最前面的任务，执行后面的任务
     * CallerRunsPolicy：由主线程, 也就是当前调用线程处理该任务
     */
    static {
        pool = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES, new ArrayBlockingQueue(20));
    }

    private void method() {
        TestThread testThread =
                new TestThread("1", "2", "3");
        pool.execute(testThread);
    }

}
