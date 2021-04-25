package com.example.springbootdemo2021.spring.listen;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Describe 定义一个事件监听者,实现ApplicationListener接口，重写 onApplicationEvent() 方法；
 * @Author wangzejun
 * @Date 2021/4/2 11:08
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    //使用onApplicationEvent接收消息
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMessage();
        System.out.println("接收到的信息是："+msg);
    }

}

