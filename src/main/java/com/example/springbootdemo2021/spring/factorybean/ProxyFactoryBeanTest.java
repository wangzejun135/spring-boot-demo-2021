package com.example.springbootdemo2021.spring.factorybean;

import com.example.springbootdemo2021.spring.aop.jdk.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/4/2 18:27
 */
public class ProxyFactoryBeanTest {
    // spring配置对象
    private static ApplicationContext context = null;

    public static void main(String[] args) {
        // 创建上下文容器
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        // 从Spring容器获得内容
        UserDao userDao = (UserDao) context.getBean("userDaoProxy");
        userDao.addUser();
        userDao.deleteUser();
    }
}
