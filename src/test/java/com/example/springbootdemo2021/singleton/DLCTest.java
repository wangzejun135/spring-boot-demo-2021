package com.example.springbootdemo2021.singleton;

/**
 * @Describe 双重检查懒汉式，双重锁：double lock check，推荐
 * 懒汉式：线程不安全
 * 恶汉式：项目启动加载慢，浪费性能
 * @Author wangzejun
 * @Date 2021/3/20 15:47
 */
public class DLCTest {

    private static volatile DLCTest dlcTest;

    // 定义私有构造方法
    private DLCTest(){
    }


    public static DLCTest getInstance(){
        if(dlcTest == null){
            synchronized (DLCTest.class) {
                if (dlcTest == null) {
                    dlcTest = new DLCTest();
                }
            }
        }
        return dlcTest;
    }

    private String aa (){
        String aa = null;
        synchronized (this) {
            aa = "123";
        }
        return aa;
    }

}
