package study2021.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/16 14:29
 */
public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("enter");
        Thread.sleep(1000);
        System.out.println("exit");
        return "SUCCESS";
    }

    public static void main(String[] args) {
        CallableDemo demo = new CallableDemo();
        String aa = null;
        String bb = null;
        try {
            FutureTask<String> futureTask = new FutureTask<>(demo);
            FutureTask<String> futureTask2 = new FutureTask<>(demo);
            Thread thread = new Thread(futureTask);
            Thread thread2 = new Thread(futureTask2);
            thread.start();
            thread2.start();
            aa = futureTask.get();
            bb = futureTask2.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(aa);
        System.out.println(bb);
        System.out.println("执行完毕");
    }

    @Test
    public void test01() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallableDemo callableDemo = new CallableDemo();
        Future<String> future = executorService.submit(callableDemo);
        System.out.println("123");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
