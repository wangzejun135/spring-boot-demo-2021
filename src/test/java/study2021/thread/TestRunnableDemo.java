package study2021.thread;

public class TestRunnableDemo implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("welcome to spring-boot");

    }

    public static void main(String[] args) {
        TestRunnableDemo testRunnableDemo = new TestRunnableDemo();
        Thread thread = new Thread(testRunnableDemo);
        thread.start();
        System.out.println("我是main方法");

    }

}
