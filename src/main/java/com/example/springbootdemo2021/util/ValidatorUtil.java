/*
 * 文  件  名：ValidatorUtil.java
 * 版        权：Copyright 2012-2014 Huawei Tech.Co.Ltd. All Rights Reserved.
 * 描        述：校验工具类
 * 修  改  人：hKF13242
 * 修改时间：2009-2-10
 * 修改内容：新增
 */
package com.example.springbootdemo2021.util;

import java.util.Collection;
import java.util.Date;


/**
 * 校验工具类
 *
 * @author hKF13242
 * @version CMR20 2013-8-28
 * @since V100R001C01LCM020
 */
public class ValidatorUtil {
    /**
     * 验证集合是否为null或为空集
     */
    public static boolean isEmpty(Collection<?> c) {
        return (c == null) || c.isEmpty();
    }

    /**
     * 验证是否不为null且不为空集
     */
    public static boolean isNotEmpty(Collection<?> c) {
        return !isEmpty(c);
    }

    /**
     * 整型数组是否为空
     *
     * @param a 整型数组
     * @return true：数组为空
     * @author mWX177641
     */
    public static boolean isEmpty(int[] a) {
        return null == a || a.length == 0;
    }

    /**
     * 整形数组是否不为空
     *
     * @param a 整型数组
     * @return true：数组不为空
     */

    public static boolean isNotEmpty(int[] a) {
        return !isEmpty(a);
    }

    /**
     * 引用数组是否为空
     *
     * @param <T> 泛型
     * @param a   泛型数组
     * @return true：数组为空
     */
    public static <T> boolean isEmpty(T[] a) {
        return null == a || a.length == 0;
    }

    /**
     * 引用数组是否不为空
     *
     * @param <T> 泛型
     * @param a   泛型数组
     * @return true：数组不为空
     */
    public static <T> boolean isNotEmpty(T[] a) {
        return !isEmpty(a);
    }

    /**
     * 判断对象是否为空
     *
     * @param <T> 泛型
     * @param obj 泛型对象
     * @return true：对象为空
     */
    public static <T> boolean isNull(T obj) {
        return obj == null;
    }

    /**
     * 判断对象是否不为空
     *
     * @param <T> 泛型
     * @param obj 泛型对象
     * @return true：对象不为空
     */
    public static <T> boolean isNotNull(T obj) {
        return !isNull(obj);
    }

    /**
     * 判断是否在提示版本升级时间内
     *
     * @param timeConfig 时间区间以";"，每一个区间以"-"分隔
     * @param nowDate    当前时间
     * @return true：在提示版本升级时间内
     * @author mWX177641
     */
    public static boolean isInTime(String timeConfig, Date nowDate) {
        boolean flag = false;

        if (StrUtil.isNotEmpty(timeConfig)) {
            String[] timeStrs = timeConfig.split(";");
            if (null != timeStrs && timeStrs.length > 0) {
                for (String timeStr : timeStrs) {
                    String[] times = timeStr.split("-");

                    if (null != times && 2 == times.length) {
                        String startTime = DateUtil.GetNowDate() + " " + times[0];
                        Date start = DateUtil.formdate(startTime, null);

                        String endTime = DateUtil.GetNowDate() + " " + times[1];
                        Date end = DateUtil.formdate(endTime, null);

                        if (nowDate.after(start) && nowDate.before(end)) {
                            return true;
                        }

                    }
                }
            }
        }
        return flag;

    }

    /**
     * 判断当前版本是否在配置的提示升级的版本列表中
     *
     * @param versionConfig 提示升级的版本列表，以","分隔
     * @param version       当前版本
     * @return 当前版本在提示升级的版本列表内
     */
    public static boolean isInUpdateVerion(String versionConfig, String version) {
        if (StrUtil.isNotEmpty(versionConfig)) {
            String[] versionStrs = versionConfig.split(",");
            for (String v : versionStrs) {
                if (v.equalsIgnoreCase(version)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 校验日期格式为yyyyMMddHHmmss
     */
    public static boolean dateFormatError(String str) {
        if (str.length() == 14) {
            try {
                Long.parseLong(str);
            } catch (NumberFormatException e) {
                return true;
            }
        } else {
            return true;
        }
        return false;
    }

    /**
     * 判断当前时间是否小于失效时间_jinxiaxia
     *
     * @param invalidTime 失效时间
     * @return 当前时间是否小于失效时间，true：当前时间小于失效时间 false：当前时间大于或等于失效时间
     */
    public static boolean isBeforeInvalidTime(String invalidTime) {
        // 对失效时间进行日期转换
        Date invalidDate = DateUtil.formdate(invalidTime, "yyyyMMddHHmmss");

        // 当前时间是否小于失效时间
        if (null != invalidDate
                && System.currentTimeMillis() < invalidDate.getTime()) {
            return true;
        }
        return false;
    }
}
