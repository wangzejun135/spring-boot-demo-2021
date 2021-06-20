/*
 * 文 件 名:  StringTools.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  字符串工具类
 * 修 改 人:  h00101670
 * 修改时间:  2009-2-12
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.example.springbootdemo2021.util;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import com.huawei.bme.commons.om.log.DebugLog;
import com.huawei.bme.commons.om.log.LogFactory;
import com.huawei.iread.portal.common.PortalConfig;

/**
 * 字符串工具类
 * 
 * @author h00101670
 * @version CMR20 2013-8-27
 * @since V100R001C01LCM020
 */
public class StringTools
{
    /**
     * 网址头
     */
    private static String URLStart = "http://";
    
    // 配置文件节点名
    private static String IS_HTTPS="ishttps/ishttp-list";
    
    private final static DebugLog logger = LogFactory.getDebugLog(StringTools.class);
    /**
     * 构造函数
     */
    private StringTools()
    {
    }
    
    /**
     * 返回字符串的长度
     * 
     * @author mWX177641
     * @param src 输入字符串
     * @return int 字符串长度
     * 
     */

    public static int getLength(String src)
    {
        return ((null == src) || ("".equals(src))) ? 0 : src.getBytes().length;
    }
    
    /**
     * 替换null
     * 
     * @author mWX177641
     * @param o 输入对象
     * @return 转化后的字符串
     * 
     */
    public static String nvl(Object o)
    {
        return (null == o) ? "" : o.toString().trim();
    }
    
    /**
     * replace$ 返回字符串，将一个$更改为两个$
     * 
     * @author mWX177641
     * @param instr 输入字符串
     * @return 转化后的字符串
     */
    public static String replace$(String instr)
    {
        StringBuffer sb = new StringBuffer(instr);
        int place = sb.indexOf("$");
        while (place >= 0)
        {
            sb.replace(place, place + 1, "$$");
            place = sb.indexOf("$", place + 2);
        }
        return sb.toString();
    }
    
    /**
     * 获取消息
     * 
     * @author mWX177641
     * @param value 值
     * @param params 被替换的参数
     * 
     * @return 格式化后的消息
     */
    public static String getMsg(String value, Object[] params)
    {
        try
        {
            // 格式化数据
            return MessageFormat.format(value, params);
        }
        catch (Exception ex)
        {
            return value;
        }
    }
    
    /**
     * 钱币转化(分转元)
     * 
     * @author mWX177641
     * @param s （RMB）分
     * @param def 默认值(分)
     * @return （RMB）元
     */
    public static float fenToYuan(String s, float def)
    {
        float fee = StringTools.toFloat(s, def);
        fee = fee / 100;

        return fee;
    }
    
    /**
     * 字符串转浮点
     * 
     * @author mWX177641
     * @param s 字符串
     * @param def 默认浮点值
     * @return 字符串的浮点值
     */
    public static float toFloat(String s, float def)
    {
        float f = def;

        try
        {
            f = Float.parseFloat(s);
        }
        catch (Exception e)
        {
            f = def;
        }
        return f;
    }
    
    /**
     * 字符串转整形
     * 
     * @author mWX177641
     * @param s 字符串
     * @param def 默认整形值
     * @return 字符串的整形值
     */
    public static int toInt(String s, int def)
    {
        // modify by zKF39164 at 2011-12-30 for IRD-22030 begin
        int value = def;
        try
        {
            if (StringUtils.isNotEmpty(s))
            {
                value = Integer.parseInt(s);
            }
            else
            {
                value = def;
            }
        }
        catch (Exception e)
        {
            value = def;
        }

        // modify by zKF39164 at 2011-12-30 for IRD-22030 end
        return value;
    }
    
    /**
     * 将String类型转换成long型
     * 
     * @author t00130406
     * @param s 字符串
     * @param def 默认值
     * @return 字符串对应的的long值
     */
    public static long toLong(String s, long def)
    {
        long value;

        try
        {
            if (StringUtils.isNotEmpty(s))
                value = Long.parseLong(s);
            else
                value = def;
        }
        catch (Exception e)
        {
            value = def;
        }

        return value;
    }
    
    /**
     * 两个值中的小值
     * 
     * @author mWX177641
     * @param s1 值 1
     * @param s2 值2
     * @return 两个值中的小值
     */
    public static int getMin(int s1, int s2)
    {
        return s1 <= s2 ? s1 : s2;
    }
    
    /**
     * 判断传入的值是否大于0
     * 
     * @author mWX177641
     * @param s 传入的字符传
     * @param def 默认的值
     * @return 大于0返回值本身，否则返回默认值
     */
    public static int toBigThanZero(String s, int def)
    {
        int value;

        try
        {
            value = Integer.parseInt(s);
            if (value <= 0)
            {
                value = def;
            }
        }
        catch (Exception e)
        {
            value = def;
        }

        return value;
    }
    
    /**
     * 判断接口是否必须https访问
     * 
     * @author cxn
     * @param url 传入的接口
     * @return 返回true,表示必须通过https访问
     */ 
    
    public static boolean isHttpsUrl(String url){

        String httpsURL = PortalConfig.get(IS_HTTPS, "");
        String[] excepts = httpsURL.split(",");
        for (int i = 0; i < excepts.length; i++)
        {
            /*if (url.endsWith(excepts[i].trim()))
            {
                return true;
            }*/
        	
        	if (StrUtil.isEq(url, excepts[i].trim()))
        	{
        		return true;
        	}
        }

        return false;
    
    }
    
    /**
     * 判断当前访问的url是否是系统无须进行会话校验的url
     * 
     * @author mWX177641
     * @param url
     * @return true:url无需进行会话校验
     */
    public static boolean isExceptUrl(String url)
    {
        String exceptURL = PortalConfig.get("common/except-url", "");
        
        if (logger.isDebugEnable())
        {
        	logger.debug("except-url are : " + exceptURL + "curUrl is : " + url);
        }

        String[] excepts = exceptURL.split(",");
        for (int i = 0; i < excepts.length; i++)
        {
            if (url.endsWith(excepts[i].trim()))
            {
                if (logger.isDebugEnable())
                {
                	logger.debug("curUrl is : " + url + " and match except-url");
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * 判断当前访问的action是否是AccessFilter过滤的action
     * 
     * @author zhongbaohui
     * @param actionName
     * @return true:放通状态下action功能无效
     */
    public static boolean isExceptAction(String actionName)
    {
        String exceptAction = PortalConfig.get("common/except-action", "");
        
        if (logger.isDebugEnable())
        {
        	logger.debug("except-action are : " + exceptAction + "curAction is : " + actionName);
        }
        
        String[] excepts = exceptAction.split(",");
        for (int i = 0; i < excepts.length; i++)
        {
            if (actionName.endsWith(excepts[i].trim()))
            {
                if (logger.isDebugEnable())
                {
                	logger.debug("curAction is : " + actionName + " and match guestPass-action");
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * 判断是否为可放通的请求
     *
     * @author GYL
     * @param actionName
     * @return
     */
    public static boolean isServicePassAction(String actionName)
    {
        String servicePassdAction = PortalConfig.get("common/service-pass-action", "getChapterList,getChapterInfo,getChapterInfo2,getReloadChapterInfo,getPartContent");
        
        if (logger.isDebugEnable())
        {
            logger.debug("service-pass-action are : " + servicePassdAction + ", currentAction is : " + actionName);
        }
        
        String[] excepts = servicePassdAction.split(",");
        for (int i = 0; i < excepts.length; i++)
        {
            if (actionName.endsWith(excepts[i].trim()))
            {
                if (logger.isDebugEnable())
                {
                    logger.debug("currentAction is : " + actionName + " and match service-pass-action");
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * 判断当前访问的action是否是SdkServerAccessFilter过滤的action
     * 
     * @author zhongbaohui
     * @param actionName
     * @return true:放通状态下action功能无效
     */
    public static boolean isExceptSdkAction(String actionName)
    {
        String exceptSdkAction = PortalConfig.get("common/except-sdkaction", "");
        
        String[] excepts = exceptSdkAction.split(",");
        for (int i = 0; i < excepts.length; i++)
        {
            if (actionName.endsWith(excepts[i].trim()))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 判断当前访问的action是否是AccessFilter过滤的action
     * 
     * @author zhongbaohui
     * @param actionName
     * @return true:放通状态下action功能无效
     */
    public static boolean isSignAction(String actionName)
    {
        String exceptAction = PortalConfig.get("common/sign-action", "");
        
        String[] excepts = exceptAction.split(",");
        for (int i = 0; i < excepts.length; i++)
        {
            if (actionName.endsWith(excepts[i].trim()))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 将字符串转换成日期形
     * 
     * @author mWX177641
     * @param time 日期字符串
     * @param pattern 解析的格式
     * @return 日期形
     */
    public static Date timeStr2Date(String time, String pattern)
    {
        if (null == time)
        {
            throw new IllegalArgumentException("time parameter can not be null");
        }
        if (null == pattern)
        {
            throw new IllegalArgumentException("pattern parameter can not be null");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, new Locale("EN"));
        try
        {
            return sdf.parse(time);
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException("using [" + pattern + "] parse [" + time + "] failed");
        }
    }
    
    /**
     * 将日期型转换成字符串
     * 
     * @author mWX177641
     * @param time 时间
     * @param pattern 时间格式
     * @return 日期字符串
     */
    public static String date2TimeStr(Date time, String pattern)
    {
        if (null == pattern)
        {
            throw new IllegalArgumentException("pattern parameter can not be null");
        }
        if (null == time)
        {
            throw new IllegalArgumentException("time parameter can not be null");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, new Locale("EN"));
        return sdf.format(time);
    }
    
    /**
     * 元转分
     * 
     * @author mWX177641
     * @param s （RMB）元
     * @param def 默认（RMB）元
     * @return （RMB）分
     */
    public static int yuanToFen(String s, int def)
    {
        float yuan = StringTools.toFloat(s, def);
        int fen = (int) (yuan * 100);

        return fen;
    }
    
    /**
     * 去掉两位的打折数字的末位0
     * 
     * @author mWX177641
     * @param discount 打折数字
     * @return 去掉0后的打折数字
     */
    public static String convertDiscount(String discount)
    {
        if (discount == null || "".equals(discount.trim()))
        {
            return "";
        }
        else if (discount.endsWith("0"))
        {
            return discount.substring(0, discount.length() - 1);
        }
        else
        {
            return discount;
        }
    }
    
    /**
     * 如果一个字符串没有给定值或为空，则给定一个默认值
     * 
     * @author mWX177641
     * @param s 给定的字符串
     * @param def 默认字符串
     * @return 字符串
     * @see [类、类#方法、类#成员]
     */
    public static String asDefault(String s, String def)
    {
        if ((s == null) || "".equals(s.trim()))
        {
            return def;
        }
        else
        {
            return s;
        }
    }
    
    /**
     * 替换字符串中指定字符
     * 
     * @author mWX177641
     * @param str 需要处理的字符串
     * @param oldStr 要替换的字符串
     * @param newStr 替换的新字符串
     * @return
     */
    public static String replaceSpecChar(String str, String oldStr, String newStr)
    {
        if (StrUtil.isEmpty(str))
        {
            return str;
        }
        return str.replaceAll(oldStr, newStr);
    }
    
    /**
     * 判断字符串是否为null对象或是空白字符
     * 
     * @author mWX177641
     * @param str 给定的字符串
     * @return true：空字符串或者null
     */
    public static boolean isEmpty(String str)
    {
        return ((str == null) || (str.trim().length() == 0));
    }
    
    /**
     * 判断字符串是否为null对象或是空白字符
     * 
     * @author mWX177641
     * @param str
     * @return false：空字符串或者null
     */
    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }
    
    /**
     * 判断字符串是否是数字
     * 
     * @author mWX177641
     * @param str 字符串
     * @return true：是数字
     */
    public static boolean isDigtial(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        return str.matches("\\d+");
    }
    
    /**
     * 替换反斜线"\"为斜线"/"
     * 
     * @author mWX177641
     * @param str 要处理的字符串
     * @return 处理后的字符串
     */
    public static String replaceBacklash(String str)
    {
        if (isEmpty(str))
        {
            return "";
        }
        else
        {
            return str.replace("\\", "/");
        }
    }
    
    /**
     * 安全取子串
     * 
     * @author mWX177641
     * @param str 被截取的字符串
     * @param begin 起始位置
     * @param end 结束位置
     * @return 子串
     */
    public static String subString(String str, int begin, int end)
    {
        if (str == null)
        {
            return str;
        }

        int b = Math.max(begin, 0);
        int e = Math.min(end, str.length());
        return str.substring(b, e);
    }
    
    /**
     * string转int
     * 
     * @author mWX177641
     * @param str 字符串
     * @param def 默认int值
     * @return 字符串对应的int值
     */
    public static Integer stringToInteger(String str, int def)
    {
        int strInt = 0;
        try
        {
            strInt = Integer.valueOf(str);
        }
        catch (NumberFormatException e)
        {
            strInt = def;
        }
        return strInt;
    }
    
    /**
     * 判断字符串中是否包含特殊字符
     * 
     * @author mWX177641
     * @param str 给定的字符串
     * @return true：不包含
     */
    public static boolean check(String str)
    {
        if (!StringTools.isEmpty(str))
        {
            return str.matches("^[A-Za-z0-9]*$");
        }
        return false;

    }
    
    /**
     * 从URL中获取IP地址
     * 
     * @author mWX177641
     * @param URL URL地址
     * @return ip地址
     */
    public static String getIPOfURL(String URL)
    {
        // modify by kf39172 at Oct 28, 2011 for WORK-5837 begin
        String IP = "127.0.0.1";

        if (!URL.startsWith(URLStart))
        {
            return IP;
        }
        java.net.URI uri = null;
        try
        {
            uri = new java.net.URI(URL);
        }
        catch (URISyntaxException e)
        {
            return IP;
        }

        IP = uri.getHost();
        if (isEmpty(IP))
        {
            IP = "127.0.0.1";
        }
        return IP;
        // modify by kf39172 at Oct 28, 2011 for WORK-5837 end
    }
    
    /**
     * 获取字符串中指定字节长度的值
     * 
     * @param str 字符串
     * @param bytesCount 指定长度
     * @return 字符串中指定字节长度的值
     */
    public static String getSubstrFromByteArray(String str, int bytesCount)
    {

        // modify by kf39172 at Oct 28, 2011 for WORK-5837 begin
        // 传入为空则不做任何处理
        if (str.trim().length() == 0)
        {
            return str;
        }

        // 奇数减去一位
        if (bytesCount % 2 != 0)
        {
            bytesCount = bytesCount - 1;
        }

        // 截取位数必须合法
        if (bytesCount <= 0)
        {
            return str;
        }

        byte[] bytes = null;
        try
        {
            bytes = str.getBytes("GBK");
        }
        catch (UnsupportedEncodingException e)
        {

            return str;
        }

        // 如果截取的长度超过实际长度，应该对实际长度减1
        if (bytes.length < bytesCount)
        {
            bytesCount = bytes.length;
        }

        char[] chars = new String(bytes, 0, bytesCount - 1).toCharArray();
        char[] charsPlus = new String(bytes, 0, bytesCount - 1).toCharArray();

        if (chars.length == charsPlus.length)
            return new String(bytes, 0, bytesCount);

        return new String(bytes, 0, bytesCount - 1);
        // modify by kf39172 at Oct 28, 2011 for WORK-5837 end
    }
    
    /**
     * 判断当前访问的url是否是需要激活的接口
     * 
     * @author mWX177641
     * @param url
     * @return true:url无需进行会话校验
     */
    public static boolean isActiveUrl(String url)
    {
        String activeURL = PortalConfig.get("common/active-url", "");

        String[] actives = activeURL.split(",");
        for (int i = 0; i < actives.length; i++)
        {
            if (url.endsWith(actives[i].trim()))
            {
                return true;
            }
        }

        return false;
    }
    
    /**
     * 判断是否是ios版本
     * 
     * @author mWX169736
     * @param clientVersion 客户端版本号
     * @return true:是ios版本;false：不是ios版本
     */
    public static boolean isIosVersion(String clientVersion)
    {
        String iosVersion = PortalConfig.get("common/ios-version", "CMREAD_iPhone");

        if (StrUtil.isNotEmpty(clientVersion))
        {
            return clientVersion.startsWith(iosVersion);
        }

        return false;
    }
    
    /**
     * 
     * 判断以逗号分隔的枚举值中是否包含某个枚举值
     *
     * @author gyl
     * @param supStr
     * @param subStr
     * @return
     */
    public static boolean quoteSplitStrContains(String supStr, String subStr)
    {
        if (StringUtils.isEmpty(supStr) || StringUtils.isEmpty(subStr))
        {
            return false;
        }
        
        supStr = supStr.trim();
        subStr = subStr.trim();
        if (subStr.equals(supStr) || supStr.startsWith(subStr + ",") || supStr.endsWith("," + subStr)
            || supStr.contains("," + subStr + ","))
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * 左侧补齐
     * @param str
     * @param length
     * @param appendStr
     * @return
     */
    public static String leftAppend(String str, int length, String appendStr)
    {
    	str = asDefault(str, "");
    	
    	if (str.length() >= length || isEmpty(appendStr))
    	{
    		return str;
    	}
    	
    	StringBuffer rtnStr = new StringBuffer();
    	
    	for (int strLen = str.length(); strLen < length; strLen++)
    	{
    		rtnStr.append(appendStr);
    	}
    	rtnStr.append(str);
    	
    	return rtnStr.toString();
    }

    /**
     * 判断两字符串是否相等
     * 
     * @param str1
     * @param str2
     * @return [参数说明]
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEq(String str1, String str2)
    {
        if (str1 == null)
        {
            return str2 == null;
        }
        return str1.equals(str2);
    }
    
}
