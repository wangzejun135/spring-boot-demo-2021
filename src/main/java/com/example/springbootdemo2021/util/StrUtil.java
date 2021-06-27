/*
 * 文 件 名:  StrUtil.java
 * 描    述:  字符串工具类
 */
package com.example.springbootdemo2021.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 字符串工具类
 *
 * @author 吴飞00106856
 * @version CMR20 2013-8-27
 * @since V100R001C01LCM020
 */
public class StrUtil {
    /**
     * 构造函数
     */
    private StrUtil() {

    }

    /**
     * 允许null对象的trim方法
     *
     * @param str 给定的字符串
     * @return trim后的字符串
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    /**
     * 判断字符串是否为null对象或是空白字符
     *
     * @param str 给定的字符串
     * @return true：字符串为空
     * @author mWX177641
     */
    public static boolean isEmpty(String str) {
        return ((str == null) || (str.trim().length() == 0));
    }

    /**
     * 判断字符串是否不为null对象或是空白字符
     *
     * @param str 给定的字符串
     * @return true：字符串不为空
     * @author mWX177641
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断两个字符串是否相等(忽略大小写)
     *
     * @param str        字符串1
     * @param compareStr 字符串2
     * @return true：相等， false：不相等
     * @author zWX190898
     */
    public static boolean isEqsIgnoreCase(String str, String compareStr) {
        if (str == null || compareStr == null) {
            return false;
        }
        return str.equalsIgnoreCase(compareStr);
    }

    /**
     * 判断两个字符串是否相等
     *
     * @param str   字符串1
     * @param other 字符串2
     * @return true：相等
     * @author mWX177641
     */
    public static boolean isEq(String str, String other) {
        if (str == null) {
            return other == null;
        }
        return str.equals(other);
    }

    /**
     * 判断两个字符串是否不相等
     *
     * @param str   字符串1
     * @param other 字符串2
     * @return true：不相等
     * @author mWX177641
     */
    public static boolean isNotEq(String str, String other) {
        return !isEq(str, other);
    }

    /**
     * 判断字符串和整数是否在字符串上相等
     *
     * @param str   字符串
     * @param other 整数
     * @return true：相等
     * @author mWX177641
     */
    public static boolean isEq(String str, int other) {
        return String.valueOf(other).equals(str);
    }

    /**
     * 判断字符串和整数是否在字符串上不相等
     *
     * @param str   字符串
     * @param other 整数
     * @return true：不相等
     * @author mWX177641
     */
    public static boolean isNotEq(String str, int other) {
        return !isEq(str, other);
    }

    /**
     * 判断字符串和整数是否在字符串上相等
     *
     * @param i   整数
     * @param str 字符串
     * @return true：相等
     * @author mWX177641
     */
    public static boolean isEq(int i, String str) {
        return String.valueOf(i).equals(str);
    }

    /**
     * 判断字符串和整数是否在字符串上不相等
     *
     * @param i   整数
     * @param str 字符串
     * @return true：不相等
     * @author mWX177641
     */
    public static boolean isNotEq(int i, String str) {
        return !isEq(i, str);
    }

    /**
     * 判断该字符串是否与后面某个整型参数在字符串上相等
     *
     * @param base    字符串
     * @param matched 整型数组
     * @return true：相等
     * @author mWX177641
     */
    public static boolean matchs(String base, int... matched) {
        int b;
        try {
            b = Integer.parseInt(base);
        } catch (Exception e) {
            return false;
        }

        for (int i = 0; i < matched.length; i++) {
            if (b == matched[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断 该整数是否与后面的某个整数是否相等
     *
     * @param base    整数
     * @param matched 整型数组
     * @return true：相等
     * @author mWX177641
     */
    public static boolean matchs(int base, int... matched) {
        for (int i = 0; i < matched.length; i++) {
            if (base == matched[i]) {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断字符串是否与其后面某个参数相等
     *
     * @param base    字符串
     * @param matched 字符串数组
     * @return true：相等
     * @author mWX177641
     */
    public static boolean matchs(String base, String... matched) {
        for (int i = 0; i < matched.length; i++) {
            if (StrUtil.isNotEmpty(matched[i])) {
                if (matched[i].equals(base)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 对象转换为String
     *
     * @param o 对象
     * @return 如果对象为null，则会返回null对象，而不是返回字符串"null"
     * @author mWX177641
     */
    public static String valueOf(Object o) {
        return (o == null) ? null : o.toString();
    }

    /**
     * 将int型转换为字符串
     *
     * @param i int值
     * @return 字符串
     * @author mWX177641
     */
    public static String valueOf(int i) {
        return String.valueOf(i);
    }

    /**
     * 对象转字符串，若对象为空，返回默认值
     *
     * @param o   对象
     * @param def 默认值
     * @return
     * @author mWX177641
     */
    public static String valueOf(Object o, String def) {
        return (o == null) ? def : o.toString();
    }

    /**
     * 将long型转换为字符串
     *
     * @param l long值
     * @return 字符串
     * @author mWX177641
     */
    public static String valueOf(long l) {
        return String.valueOf(l);
    }

    /**
     * 将double型转换为字符串
     *
     * @param d double值
     * @return 字符串
     * @author mWX177641
     */
    public static String valueOf(double d) {
        return String.valueOf(d);
    }

    /**
     * 判断一个字符串是否全部是整数
     *
     * @param str 字符串
     * @return true：是整数
     */
    public static boolean isNumber(String str) {
        if (str != null) {
            return str.matches("-?\\d+");
        } else {
            return false;
        }
    }

    /**
     * 判断一个字符串是否全部是正整数
     *
     * @param str 字符串
     * @return true：是正整数
     */
    public static boolean isPositiveNumber(String str) {
        if (str != null) {
            return str.matches("^[0-9]*[1-9][0-9]*$");
        } else {
            return false;
        }
    }

    /**
     * 判断一个字符串是否全部是正整数
     *
     * @param str 字符串
     * @return true：是整数
     */
    public static boolean isPNumber(String str) {
        if (str != null) {
            return str.matches(".*(\\d){11,}.*");
        } else {
            return false;
        }
    }

    /**
     * 判断非11位数字开头的昵称
     *
     * @param str 待校验字符串
     * @return true:非11位数字开头的昵称
     * @author shanlingling
     */
    public static boolean checkNickNameValid(String str) {
        if (StrUtil.isNotEmpty(str)) {
            return !str.matches("^\\d{11}[\\w\\W]*");
        }
        return false;
    }

    /**
     * 将String类型转换为Int类型,当转换失败时返回默认值
     *
     * @param str 待转换的字符串
     * @param def 默认值
     * @return
     * @author c00126000
     */
    public static int toInt(String str, int def) {
        int result = def;
        try {
            result = Integer.parseInt(str);
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    /**
     * 将String类型转换为Double类型,当转换失败时返回默认值
     *
     * @param str 待转换的字符串
     * @param def 默认值
     * @return
     * @author c00126000
     */
    public static double toDouble(String str, double def) {
        double result = def;
        try {
            result = Double.parseDouble(str);
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    /** modified by yukuangzhou yKF72055 at 2012-6-27 for CMR13_CPortal_REQ-555 begin */
    /**
     * 字符串转换为整形
     *
     * @param str 字符串
     * @return 整型值
     * @author mWX177641
     */
    public static Integer toInteger(String str) {
        try {
            if (str == null) {
                return null;
            }

            DecimalFormat dcmFmt = new DecimalFormat("#0");
            String strDouble = dcmFmt.format(Double.parseDouble(str));
            return Integer.parseInt(strDouble);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     *
     * @param s 需要得到长度的字符串
     * @return 得到的字符串长度
     */
    public static int length(String s) {
        if (s == null) {
            return 0;
        }
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i])) {
                len++;
            }
        }
        return len;
    }

    // add by c00126000 at 2011-12-27 for IRD-21884 begin

    /**
     * 计算字符串的字符长度（中文、英文均按一个字符计算） 如："中文abc" 长度为 5
     *
     * @param s 字符串
     * @return 返回的字符串长度
     * @author mWX177641
     */
    public static int lengthc(String s) {
        if (s == null) {
            return 0;
        }
        return s.length();
    }

    // add by c00126000 at 2011-12-27 for IRD-21884 end

    /**
     * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符）
     *
     * @param c 指定的字符
     * @return true:Ascill字符
     * @author mWX177641
     */
    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }

    // modify by wufei00106856 at 2011-12-13 for REQ-930 begin

    /**
     * 分隔字符串
     *
     * @param str   被分隔的字符串
     * @param regex 分隔符
     * @return 分隔得到的数组
     * @author mWX177641
     */
    public static String[] split(String str, String regex) {
        if (str == null) {
            return new String[]{""};
        }
        if (regex == null) {
            return new String[]{str};
        }

        return str.split(regex);
    }

    /**
     * 判断字符串是否以标点符号结尾（句号、逗号、分号）
     *
     * @param str 给定的字符串
     * @return true：以标点符号结尾
     * @author mWX177641
     */
    public static boolean endWithPunctuation(String str) {
        if (isEmpty(str)) {
            return false;
        }

        return str.endsWith("。") || str.endsWith(".") || str.endsWith("，") || str.endsWith(",") || str.endsWith("；")
                || str.endsWith(";") || str.endsWith("!") || str.endsWith("！");
    }

    // add by c00126000 at 2012-2-13 for IRD-22403 end

    /**
     * 判断字符串是否包含字符串
     *
     * @param str  字符串1
     * @param mark 字符串2
     * @return true： 字符串1包含字符串2
     * @author mWX177641
     */
    public static boolean containMark(String str, String mark) {
        if (isEmpty(str)) {
            return false;
        }

        return str.contains(mark);
    }

    /**
     * 格式化URL包含token和校验IP
     *
     * @param url        url地址
     * @param tokenId    tokenID
     * @param isVerifyIP 是否检验ip
     * @return 格式化后的URL
     */
    public static String formatURLContainToken(String url, String tokenId, Boolean isVerifyIP) {
        if (StrUtil.isNotEmpty(url) && StrUtil.isNotEmpty(tokenId)) {
            if (containMark(url, "?")) {
                if (isVerifyIP) {
                    if (containMark(url, "=")) {
                        url = url + "&tokenid=" + tokenId + "&ck=0";
                    } else {
                        url = url + "tokenid=" + tokenId + "&ck=0";
                    }

                } else {
                    if (containMark(url, "=")) {
                        url = url + "&tokenid=" + tokenId;
                    } else {
                        url = url + "tokenid=" + tokenId;
                    }
                }
            } else {
                if (isVerifyIP) {
                    url = url + "?tokenid=" + tokenId + "&ck=0";
                } else {
                    url = url + "?tokenid=" + tokenId;
                }
            }
        }
        return url;
    }

    /**
     * 子字符串是否包含在字符串列表中
     *
     * @param str     字符串
     * @param strList 字符串列表
     * @return true：包含
     */
    public static boolean containSubStr(String str, String[] strList) {
        boolean containSub = false;
        if (strList.length == 0 || isEmpty(str)) {
            containSub = false;
        }
        for (int i = 0; i < strList.length; i++) {

            if (!strList[i].isEmpty()) {
                if (str.startsWith(strList[i])) {
                    containSub = true;
                }
            }

        }
        return containSub;
    }

    /**
     * 近似匹配，找到比数组中小的，最接近输入值的数
     */
    public static int match(int source, int... matched) {
        int x = 0;
        int target = 0;
        for (int i = 0; i < matched.length; i++) {
            if (source >= matched[i]) {
                x = matched[i] - source;

                if (Math.abs(x) < Math.abs(target - source)) {
                    target = matched[i];
                }
            }
        }
        return target;
    }

    /**
     * 用指定的分隔符号拆分字符串
     *
     * @param srcStr 待拆分的字符串
     * @param sep    分隔符号
     * @return 返回拆分后的字符串列表
     * @author r00138849
     */
    public static List<String> splitString(String srcStr, String sep) {
        List<String> list = new ArrayList<String>();
        if (!isEmpty(srcStr)) {
            String[] temp = srcStr.split(sep);
            for (int i = 0; i < temp.length; i++) {
                list.add(temp[i]);
            }
        }
        return list;
    }

    /**
     * 将列表用指定的符号组装成String
     *
     * @param source    待组装的列表
     * @param seperator 分隔符
     * @return 组装后的字符串
     * @author kf56385
     */
    public static String parseListToStrBySeperator(List<String> source, String seperator) {
        String result = "";
        // 参数检查
        if (isEmpty(source)) {
            return result;
        }
        // 执行组装
        for (int i = 0; i < source.size(); i++) {
            String str = source.get(i);

            if (i == source.size() - 1) {
                result += str;
            } else {
                result += str + seperator;
            }
        }
        return result;
    }

    /**
     * 验证集合是否为null或为空集
     */
    public static boolean isEmpty(Collection<?> c) {
        return (c == null) || c.isEmpty();
    }

    /**
     * 验证集合是否为null或为空集
     */
    public static String joint(String leftStr, String... rightStr) {
        StringBuffer sb = new StringBuffer();
        sb.append(leftStr);
        for (String str : rightStr) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 对null对象进行赋值
     *
     * @param o 对象
     * @return String
     * @author wWX190899
     */
    public static String nvl(Object o) {
        return (null == o) ? "" : o.toString().trim();
    }

    /**
     * 校验支付方式是否为数字和英文逗号组合
     */
    public static boolean reg(String supportPayType) {
        String regex = "(\\d+(,\\d+)?)";
        return supportPayType.matches(regex);
    }

    /**
     * 判断指定的对象是否为空
     *
     * @param obj Object
     * @return boolean
     */
    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        }
        return false;
    }

}
