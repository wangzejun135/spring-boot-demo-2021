package com.example.springbootdemo2021.spring.aop.jdk;

import com.example.springbootdemo2021.spring.aop.aspect.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Describe 代理类
 * 生成的代理类继承了Proxy，由于java是单继承，所以只能实现接口，通过接口实现
 * @Author wangzejun
 * @Date 2021/4/2 13:32
 */
public class JDKProxy implements InvocationHandler {
    // 声明目标类接口
    private UserDao userDao;
    // 创建代理方法
    public Object createProxy(UserDao userDao) {
        this.userDao = userDao;
        // 1.类加载器
        ClassLoader classLoader = JDKProxy.class.getClassLoader();
        // 2.被代理对象实现所有接口
        Class[] clazz = userDao.getClass().getInterfaces();
        // 3.使用代理类进行增强，返回的是代理后的对象
        Object object = Proxy.newProxyInstance(classLoader, clazz,this);
        return object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 申明切面
        MyAspect myAspect = new MyAspect();
        // 增强前操作
        myAspect.checkPermissions();
        // 执行业务方法
        Object object = method.invoke(userDao, args);
        // 增强后操作，增强日志操作
        myAspect.addLog();
        return object;
    }
}
