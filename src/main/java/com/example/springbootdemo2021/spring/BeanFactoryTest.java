package com.example.springbootdemo2021.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/28 17:07
 */
public class BeanFactoryTest {

    // spring配置对象
    private static ApplicationContext context = null;

    public static void main(String[] args) {
        // 创建上下文容器
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        System.out.println("BeanFactory中Bean的数量：" + context.getBeanDefinitionCount());
        String[] bdNames = context.getBeanDefinitionNames();
        for(String str: bdNames) {
            System.out.println("bean的名字：" + str);
        }
        MyTestBean bean = (MyTestBean)context.getBean("hello");
        Map<String, String> map = new HashMap<>();

        System.out.println(bean.getTeststr());
    }

}


