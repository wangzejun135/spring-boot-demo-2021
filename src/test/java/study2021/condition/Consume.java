package study2021.condition;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Describe 消费者
 * @Author WangZeJun
 * @Date 2021/3/20 10:06
 */
public class Consume implements Runnable{
    private Queue<String> msg;
    private Lock lock;
    private Condition condition;

    public Consume(Queue<String> msg, Lock lock, Condition condition) {
        this.msg = msg;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        // 获得当前线程的名称
        System.out.println(Thread.currentThread().getName());
        int a = 0;
        while (true) {
            // 加锁
            a++;
            lock.lock();
            while (msg.isEmpty()) {
                System.out.println("消费者空了，先等待");
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
            System.out.println("消费者消费消息：" + msg.remove());
            // 唤醒处于阻塞状态下的线程
            condition.signal();
            // 释放锁
            lock.unlock();

        }
    }
}
