package com.example.springbootdemo2021.spring.aop.jdk;

/**
 * @Describe 测试类
 * @Author wangzejun
 * @Date 2021/4/2 15:05
 */
public class JDKTest {

    public static void main(String[] args) {
        // 创建代理对象
        JDKProxy jdkProxy = new JDKProxy();
        // 创建目标对象
        UserDao userDao = new UserDaoImpl();
        // 从代理对象中获取增强后的目标对象
        UserDao userDao2 = (UserDao) jdkProxy.createProxy(userDao);

        // 执行业务方法
        userDao2.addUser();
        userDao2.deleteUser();
    }
}
