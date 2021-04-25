package study2021.thread;

import java.util.ArrayList;
import java.util.List;

public class TestThreadDemo extends Thread{

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
/*        TestThreadDemo testDemo = new TestThreadDemo();
        testDemo.start();
        System.out.println("我是main方法");*/
    List<Integer> list = new ArrayList<>();


    }

}
