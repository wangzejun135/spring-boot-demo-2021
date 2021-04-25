package com.example.springbootdemo2021.spring.aop.aspect;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/4/2 13:28
 */
public class MyAspect {
    public void checkPermissions() {
        System.out.println("***权限校验***");
    }

    public void addLog() {
        System.out.println("***日志增强***");
    }
}
