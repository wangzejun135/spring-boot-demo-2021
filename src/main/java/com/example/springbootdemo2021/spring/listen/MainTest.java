package com.example.springbootdemo2021.spring.listen;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/4/2 11:44
 */
public class MainTest {
    public static void main(String[] args) {
        DemoPublisher test = new DemoPublisher();

        test.publish("发送消息");
    }
}
