package com.example.springbootdemo2021.util;

import java.util.concurrent.TimeUnit;

/**
 * @Describe 睡眠工具类
 * @Author wangzejun
 * @Date 2021/3/23 16:46
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }

    }
}
