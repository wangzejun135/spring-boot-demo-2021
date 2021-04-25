package study2021.condition;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/20 10:06
 */
public class TestCondition {

    private static final int MAX_SIZE = 5;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Queue<String> queue = new LinkedList<>();
        Product product = new Product(queue, MAX_SIZE, lock, condition);
        Consume consume = new Consume(queue, lock, condition);

        Thread thread01 = new Thread(product, "我是第一个线程");
        Thread thread02 = new Thread(consume, "我是第二个线程");

        thread01.start();
        thread02.start();

    }


}
