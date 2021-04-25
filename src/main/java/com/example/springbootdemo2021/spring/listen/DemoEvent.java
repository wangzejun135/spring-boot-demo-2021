package com.example.springbootdemo2021.spring.listen;

import org.springframework.context.ApplicationEvent;

/**
 * @Describe Spring观察者模式
 * 定义一个事件,继承自ApplicationEvent并且写相应的构造函数
 * @Author wangzejun
 * @Date 2021/4/2 11:07
 */
public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    private String message;

    public DemoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}


