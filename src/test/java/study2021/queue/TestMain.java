package study2021.queue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/20 10:06
 */
public class TestMain {

    private static final int MAX_SIZE = 5;

    @Test
    public void handle() {
        Queue<Integer> queue = new LinkedList<>();
        Product product = new Product(queue, MAX_SIZE);
        Consume consume = new Consume(queue, MAX_SIZE);

        Thread thread01 = new Thread(product);
        Thread thread02 = new Thread(consume);

        thread01.start();
        thread02.start();

    }


}
