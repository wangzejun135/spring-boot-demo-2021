package com.example.springbootdemo2021.spring.aop.cglib;

import com.example.springbootdemo2021.spring.aop.aspect.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Describe 代理类
 * @Author wangzejun
 * @Date 2021/4/2 16:02
 */
public class CglibProxy implements MethodInterceptor {

    // 代理方法
    public Object createProxy(Object target) {
        // 创建一个动态类对象
        Enhancer enhancer = new Enhancer();
        // 确定一个需要增强的类，设置其父类
        enhancer.setSuperclass(target.getClass());
        // 添加回调函数
        enhancer.setCallback(this);
        // 返回创建的代理类
        return enhancer.create();
    }

    /**
     * proxy:根据指定父类生成代理对象
     * method:拦截的方法
     * args:拦截方法的参数数组
     * methodProxy:方法的代理对象，用于执行父类的方法
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 申明切面
        MyAspect myAspect = new MyAspect();

        // 增强前操作
        myAspect.checkPermissions();

        // 执行业务方法
        Object object = methodProxy.invokeSuper(proxy, args);

        // 增强后操作，增强日志操作
        myAspect.addLog();
        return object;
    }
}
