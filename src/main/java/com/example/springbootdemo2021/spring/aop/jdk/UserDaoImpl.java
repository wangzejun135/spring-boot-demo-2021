package com.example.springbootdemo2021.spring.aop.jdk;

/**
 * @Describe 接口实现类
 * @Author wangzejun
 * @Date 2021/4/2 13:25
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
