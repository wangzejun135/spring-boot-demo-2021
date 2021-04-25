package com.example.springbootdemo2021.spring.listen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @Describe 发布事件
 * 可以通过ApplicationEventPublisher  的 publishEvent() 方法发布消息。
 * @Author wangzejun
 * @Date 2021/4/2 11:08
 */
@Component
public class DemoPublisher {

    @Autowired
    ApplicationContext applicationContext;

    public void publish(String message){
        //发布事件
        applicationContext.publishEvent(new DemoEvent(this, message));
    }
}
