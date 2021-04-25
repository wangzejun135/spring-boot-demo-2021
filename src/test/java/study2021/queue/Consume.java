package study2021.queue;

import java.util.Queue;

/**
 * @Describe 消费者
 * @Author wangzejun
 * @Date 2021/3/20 10:06
 */
public class Consume implements Runnable{
    private Queue<Integer> msg;
    private int maxSize;

    public Consume(Queue<Integer> msg, int maxSize) {
        this.msg = msg;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (msg) {
                while (msg.isEmpty()) {
                    try {
                        msg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者消费消息：" + msg.remove());
                msg.notify();
            }

        }
    }
}
