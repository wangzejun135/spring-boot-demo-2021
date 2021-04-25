package com.example.springbootdemo2021.util;

/**
 * @Describe 字符串工具类
 * @Author wangzejun
 * @Date 2021/3/22 19:35
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }
}
