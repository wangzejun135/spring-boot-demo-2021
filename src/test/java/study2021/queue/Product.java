package study2021.queue;

import java.util.Queue;

/**
 * @Describe 生产者
 * @Author wangzejun
 * @Date 2021/3/20 10:06
 */
public class Product implements Runnable{
    private Queue<Integer> msg;
    private int maxSize;

    public Product(Queue<Integer> msg, int maxSize){
        this.msg = msg;
        this.maxSize = maxSize;
    }
    @Override
    public void run() {
        int a = 1;
        while (true) {
            synchronized (msg) {
                a++;
                while (msg.size() == maxSize) {
                    try {
                        msg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
/*                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                msg.add(a);
                System.out.println("生产者生产消息：" + a);
                // 唤醒处于阻塞状态下的线程
                msg.notify();
            }
        }
    }
}
