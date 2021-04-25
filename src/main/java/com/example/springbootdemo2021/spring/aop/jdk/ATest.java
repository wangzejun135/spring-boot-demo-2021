package com.example.springbootdemo2021.spring.aop.jdk;

/**
 * @Describe 接口实现类
 * @Author wangzejun
 * @Date 2021/4/2 13:25
 */
public class ATest extends JDKProxy {
    public void addUser() {
        System.out.println("添加用户");
    }

    public void deleteUser() {
        System.out.println("删除用户");
    }
}
