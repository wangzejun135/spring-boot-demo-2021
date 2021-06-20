package com.example.springbootdemo2021.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.time.FastDateFormat;
import org.apache.log4j.Logger;

import com.huawei.bme.commons.om.log.DebugLog;
import com.huawei.bme.commons.om.log.LogFactory;
import com.huawei.iread.portal.common.PortalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间工具类
 * 
 * @author hKF13242
 * @version [版本号, 2009-7-6]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DateUtil
{
    /**
     * 日志记录对象
     */
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 一分钟
     */
    private static final int ONE_MINUTE = 60;
    
    /**
     * 一千
     */
    private static final int ONE_THOUSAND = 1000;
    
    /**
     * 一小时
     */
    private static final int ONE_HOUR = 60;
    
    /**
     * 年
     */
    public static final int YEAR = 0;
    
    /**
     * 月
     */
    public static final int MONTH = 1;
    
    /**
     * 周
     */
    public static final int WEEK = 2;
    
    /**
     * 日
     */
    public static final int DAY = 3;
    
    /**
     * 时
     */
    public static final int HOUR = 4;
    
    /**
     * 分
     */
    public static final int MINUTE = 5;
    
    /**
     * 秒
     */
    public static final int SECOND = 6;
    
    /**
     * 毫秒
     */
    public static final int MILLISECOND = 7;
    
    /**
     * 一天的分钟
     */
    public static final int MINUTEOFDAY = 8;
    
    /**
     * 一分钟的毫秒数
     */
    public static final long ONE_MINUTE_MILLISECONDS = 60L * 1000L;
    
    /**
     * 精确到毫秒17位时间格式
     */
    public static final String DATE_FORMATE_17 = "yyyyMMddHHmmssSSS";
    
    /**
     * 年月日时分秒时间格式
     */
    public static final String YYYYMMDDHHMMSS_FORMAT = "yyyyMMddHHmmss";
    
    /**
     * 带连字符"-"年月日时分秒时间格式
     */
    public static final String YYYY_MM_DDHHMMSS_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * 带连字符"-"年月日时间格式
     */
    public static final String YYYY_MM_DD_FORMAT = "yyyy-MM-dd";
    
    /**
     * 书签/笔记的最小添加时间
     */
    public static final Date addTimeMinTime = timeStr2Date("20170401000000", YYYYMMDDHHMMSS_FORMAT);
    
    /**
     * utc时间
     */
    private static final FastDateFormat UTC_DATEFORMAT =
        FastDateFormat.getInstance("yyyyMMddHHmmss", TimeZone.getTimeZone("UTC"));
    
    /**
     * 本地时间
     */
    private static final FastDateFormat LOCAL_DATEFORMAT =
        FastDateFormat.getInstance("yyyyMMddHHmmss", TimeZone.getDefault());
    
    /**
     * 构造函数
     */
    private DateUtil()
    {
        
    }
    
    /**
     * 得到当前时间的字符格式
     * 
     * @author mWX177641
     * @return 当前时间的字符格式
     */
    public static String getCurrentTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    /**
     * 得到当前时间
     * 
     * @author mWX177641
     * @return 当前时间
     */
    public static Timestamp getCurrentDatetime()
    {
        return new Timestamp(System.currentTimeMillis());
    }
    
    /**
     * 格式化成系统常用日期格式：yyyyMMddHHmmss
     * 
     * @author mWX177641
     * @param date 时间
     * @return 格式化后的时间字符串
     */
    public static String format(Date date)
    {
        if (date == null)
        {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    
    /**
     * 格式化日期
     * 
     * @author mWX177641
     * @param date 时间
     * @param formatStr 指定格式化格式
     * @return 格式化后的时间字符串
     */
    public static String format(Date date, String formatStr)
    {
        if (date == null)
        {
            return null;
        }
        
        SimpleDateFormat sf = new SimpleDateFormat(formatStr);
        return sf.format(date);
    }
    
    /**
     * 判断两个日期是否为同年同月
     * 
     * @author mWX177641
     * @param date1 时间1
     * @param date2 时间2
     * @return true:同年同月 false：不同年同月
     */
    public static boolean isSameYYYYMM(Date date1, Date date2)
    {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        
        return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH));
    }
    
    /**
     * 把字符串格式化日期
     * 
     * @author mWX177641
     * @param dateStr 时间字符串
     * @param formater 时间字符串的时间格式
     * @return 时间字符串对应的时间
     */
    public static Date formdate(String dateStr, String formater)
    {
        formater = (null == formater) ? "yyyy-MM-dd HH:mm:ss" : formater;
        DateFormat formatter = new SimpleDateFormat(formater);
        Date date = null;
        try
        {
            date = formatter.parse(dateStr);
        }
        catch (ParseException e)
        {
            logger.error(e.toString());
            // e.printStackTrace();
        }
        return date;
    }
    
    /**
     * 把字符串格式化日期
     * 
     * @author xiongruntu
     * @param dateStr 时间字符串
     * @param formater 时间字符串的时间格式
     * @return 时间字符串对应的时间
     */
    public static Date formdateNorm(String dateStr)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newdateStr = sdf.format(Long.parseLong(dateStr));
        Date date = null;
        try
        {
            date = sdf.parse(newdateStr);
        }
        catch (ParseException e)
        {
            logger.error(e.toString());
            // e.printStackTrace();
        }
        return date;
    }
    
//    /**
//     * 把字符串格式化日期
//     * 
//     * @author xiongruntu
//     * @param dateStr 时间字符串
//     * @param formater 时间字符串的时间格式
//     * @return 时间字符串对应的时间
//     */
//    public static Date formdateNorm2(String dateStr)
//    {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        // String newdateStr = sdf.format(dateStr);
//        Date date = null;
//        try
//        {
//            date = sdf.parse(dateStr);
//        }
//        catch (ParseException e)
//        {
//            logger.error(e.toString());
//            // e.printStackTrace();
//        }
//        return date;
//    }
    
//    /**
//     * 转换时间格式为MMdd
//     * 
//     * @author mWX177641
//     * @param dateString 时间字符串，格式为yyyyMMddHHmmss
//     * @return 时间字符串对应的MMdd时间字符串
//     */
//    public static String transDateMMdd(String dateString)
//    {
//        try
//        {
//            Date date = StringTools.timeStr2Date(dateString, "yyyyMMddHHmmss");
//            return StringTools.date2TimeStr(date, "MMdd");
//        }
//        catch (Exception e)
//        {
//            return "";
//        }
//    }
    
    /**
     * 转换时间格式为MM-dd add by 2010-6-01 KF27344
     * 
     * @author mWX177641
     * @param dateString2 时间字符串，格式为yyyy-MM-dd HH:mm:ss
     * @return 时间字符串对应的MM-dd时间字符串
     */
    public static String transDateMMdd2(String dateString2)
    {
        try
        {
            Date date = StringTools.timeStr2Date(dateString2, "yyyy-MM-dd HH:mm:ss");
            return StringTools.date2TimeStr(date, "MM-dd");
        }
        catch (Exception e)
        {
            return "";
        }
    }
    
    /**
     * 日期转换成MM-dd HH:mm:ss
     * 
     * @author cKF24529
     * @param noFormat 时间字符串，格式为yyyyMMddHHmmss
     * @return 时间字符串对应的MM-dd HH:mm:ss时间字符串
     */
    public static String transDate3(String noFormat)
    {
        try
        {
            Date date = StringTools.timeStr2Date(noFormat, "yyyyMMddHHmmss");
            return StringTools.date2TimeStr(date, "MM-dd HH:mm:ss");
        }
        catch (Exception e)
        {
            return "";
        }
    }
    
//    /**
//     * 日期转换成yyyy-MM-dd HH:mm:ss
//     * 
//     * @author mWX177641
//     * @param noFormat 时间字符串，格式为yyyyMMddHHmmss
//     * @return String 时间字符串对应的yyyy-MM-dd HH:mm:ss时间字符串
//     */
//    public static String transDate(String noFormat)
//    {
//        try
//        {
//            // 20100209111844
//            Date date = StringTools.timeStr2Date(noFormat, "yyyyMMddHHmmss");
//            return StringTools.date2TimeStr(date, "yyyy-MM-dd HH:mm:ss");
//        }
//        catch (Exception e)
//        {
//            return "";
//        }
//    }
    
    /**
     * being add with IRD-7478 by zkf27348 at 2010-09-19 日期转换,不下放秒
     * 
     * @author mWX177641
     * @param noFormat 时间字符串，格式为yyyyMMddHHmmss
     * @return String 时间字符串对应的yyyy-MM-dd HH:mm:ss时间字符串
     */
    public static String transDateWithSecconds(String noFormat)
    {
        try
        {
            Date date = StringTools.timeStr2Date(noFormat, "yyyyMMddHHmmss");
            return StringTools.date2TimeStr(date, "yyyy-MM-dd HH:mm:ss");
        }
        catch (Exception e)
        {
            return "";
        }
    }
    
    /**
     * 日期转换，精确到分
     * 
     * @author shanlingling
     * @param noFormat 时间字符串，格式为yyyyMMddHHmmss
     * @return String 时间字符串对应的yyyy-MM-dd HH:mm时间字符串
     */
    public static String transDateWithMinutes(String noFormat)
    {
        try
        {
            Date date = StringTools.timeStr2Date(noFormat, "yyyyMMddHHmmss");
            return StringTools.date2TimeStr(date, "yyyy-MM-dd HH:mm");
        }
        catch (Exception e)
        {
            return "";
        }
    }
    
    /** end add with IRD-7478 by zkf27348 at 2010-09-19 */
    
    /**
     * 日期转换成yyyyMMdd HH:mm:ss
     * 
     * @author mWX177641
     * @param noFormat 时间字符串，格式为yyyyMMddHHmmss
     * @return String 时间字符串对应的yyyyMMdd HH:mm:ss时间字符串
     */
    public static String transDate4(String noFormat)
    {
        try
        {
            Date date = StringTools.timeStr2Date(noFormat, "yyyyMMddHHmmss");
            return StringTools.date2TimeStr(date, "yyyyMMdd HH:mm:ss");
        }
        catch (Exception e)
        {
            return "";
        }
    }
    
    /**
     * 日期转换成yyyy-MM-dd格式
     * 
     * @param noFormat 时间字符串，格式为yyyyMMddHHmmss
     * @return 时间字符串对应的yyyy-MM-dd时间字符串
     * @see [类、类#方法、类#成员]
     */
    public static String transDate2(String noFormat)
    {
        try
        {
            Date date = StringTools.timeStr2Date(noFormat, "yyyyMMddHHmmss");
            
            return StringTools.date2TimeStr(date, "yyyy-MM-dd");
        }
        catch (Exception e)
        {
            return "";
        }
    }
    
    /**
     * 判断一个字符串是否满足给定的日期格式
     * 
     * @author mWX177641
     * @param str 时间字符串
     * @param dateFormat 时间格式
     * @return boolean true：满足 false：不满足
     * @see [类、类#方法、类#成员]
     */
    public static boolean judgeDateFormat(String str, String dateFormat)
    {
        if (str != null)
        {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            formatter.setLenient(false);
            
            try
            {
                formatter.format(formatter.parse(str));
            }
            catch (Exception e)
            {
                return false;
            }
            
            return true;
        }
        
        return false;
    }
    
    /**
     * 判断一个字符串是否满足给定的日期格式，包括长度也要一致
     * 
     * @author mWX177641
     * @param str 时间字符串
     * @param dateFormat 时间格式
     * @return boolean true：满足 false：不满足
     */
    public static boolean judgeDateFormatAndLength(String str, String dateFormat)
    {
        if (str != null)
        {
            if (str.length() != dateFormat.length())
                return false;
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            formatter.setLenient(false);
            
            try
            {
                formatter.format(formatter.parse(str));
            }
            catch (Exception e)
            {
                return false;
            }
            
            return true;
        }
        
        return false;
    }
    
    /**
     * 将日期增加一个增量，目前只能是，年，月，周，日，时、分、秒、毫秒
     * 
     * @author mWX177641
     * @param date 原始时间
     * @param delta 增量的大小
     * @param unit 增量的单位，DateUtil.YEAR, DateUtil.MONTH, DateUtil.DAY, DateUtil.HOUR,DateUtil.MINUTE, DateUtil.SECOND,
     *            DateUtil.MILLISECOND
     * @return 从格林威治时间：1970年1月1日0点起的毫秒数
     */
    public static long addDate(long date, int delta, int unit)
    {
        if ((unit < YEAR) || (unit > MILLISECOND))
        {
            throw new IllegalArgumentException(
                "time unit must in [YEAR, MONTH, WEEK, DAY, HOUR, MINUTE, SECOND, MILLISECOND], others not support");
        }
        Date dt = new Date(date);
        Calendar calendar = getLocalCalendar(dt);
        
        // 增加增量
        switch (unit)
        {
            case YEAR:
                calendar.add(Calendar.YEAR, delta);
                break;
            case MONTH:
                calendar.add(Calendar.MONTH, delta);
                break;
            case WEEK:
                calendar.add(Calendar.DAY_OF_WEEK, delta);
                break;
            case DAY:
                calendar.add(Calendar.DAY_OF_MONTH, delta);
                break;
            case HOUR:
                calendar.add(Calendar.HOUR, delta);
                break;
            case MINUTE:
                calendar.add(Calendar.MINUTE, delta);
                break;
            case SECOND:
                calendar.add(Calendar.SECOND, delta);
                break;
            case MILLISECOND:
                calendar.add(Calendar.MILLISECOND, delta);
                /* falls through */
            default:
                break;
        }
        
        // 获取新的时间，并转换成长整形
        Date ndt = calendar.getTime();
        return ndt.getTime();
    }
    
    /**
     * 获得东八时区的日历，并设置日历的当前日期
     * 
     * @author mWX177641
     * @param date 时间
     * @return 东八区时间
     */
    public static Calendar getLocalCalendar(Date date)
    {
        // 设置为GMT+08:00时区
        String[] ids = TimeZone.getAvailableIDs(8 * ONE_HOUR * ONE_MINUTE * ONE_THOUSAND);
        if (0 == ids.length)
        {
            throw new IllegalArgumentException("get id of GMT+08:00 time zone failed");
        }
        
        // 创建Calendar对象，并设置为指定时间
        Calendar calendar = new GregorianCalendar(TimeZone.getDefault());
        
        // 设置成宽容方式
        if (!calendar.isLenient())
        {
            calendar.setLenient(true);
        }
        
        // 设置SUNDAY为每周的第一天
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        
        // 设置日历的当前时间
        calendar.setTime(date);
        return calendar;
    }
    
    /**
     * 得到指定格式的Date型当前时间
     * 
     * @author mWX177641
     * @param formater 时间格式
     * @return 当前时间对应的时间格式字符串
     */
    public static Date getCurrentDate(String formater)
    {
        return formdate(getCurrentTime(), formater);
    }
    
    /**
     * 
     * 时间比较枚举类
     * 
     * @author mWX177641
     * @version CMR20 2013-8-27
     * @since V100R001C01LCM020
     */
    public static enum CompareDateFormate
    {
        year, month, day, hour, minute, second,
        
        yyyyMMddhhmmss, yyyyMMddhhmm, yyyyMMddhh, yyyyMMdd, yyyyMM,
        
        MMddhhmmss, MMddhhmm, MMddhh, MMdd, ddhhmmss, ddhhmm, ddhh, hhmmss, hhmm, mmss
    }
    
    /**
     * 时间比较器map
     */
    private final static HashMap<CompareDateFormate, int[]> map = new HashMap<CompareDateFormate, int[]>();
    
    /**
     * 初始化时间比较器map
     */
    static
    {
        map.put(CompareDateFormate.year, new int[] {Calendar.YEAR});
        map.put(CompareDateFormate.month, new int[] {Calendar.MONTH});
        map.put(CompareDateFormate.day, new int[] {Calendar.DATE});
        map.put(CompareDateFormate.hour, new int[] {Calendar.HOUR_OF_DAY});
        map.put(CompareDateFormate.minute, new int[] {Calendar.MINUTE});
        map.put(CompareDateFormate.second, new int[] {Calendar.SECOND});
        
        map.put(CompareDateFormate.yyyyMMddhhmmss,
            new int[] {Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE,
                Calendar.SECOND});
        map.put(CompareDateFormate.yyyyMMddhhmm,
            new int[] {Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE});
        map.put(CompareDateFormate.yyyyMMddhh,
            new int[] {Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY});
        map.put(CompareDateFormate.yyyyMMdd, new int[] {Calendar.YEAR, Calendar.MONTH, Calendar.DATE});
        map.put(CompareDateFormate.yyyyMM, new int[] {Calendar.YEAR, Calendar.MONTH});
        
        map.put(CompareDateFormate.MMddhhmmss,
            new int[] {Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND});
        map.put(CompareDateFormate.MMddhhmm,
            new int[] {Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE});
        map.put(CompareDateFormate.MMddhh, new int[] {Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY});
        map.put(CompareDateFormate.MMdd, new int[] {Calendar.MONTH, Calendar.DATE});
        
        map.put(CompareDateFormate.ddhhmmss,
            new int[] {Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND});
        map.put(CompareDateFormate.ddhhmm, new int[] {Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE});
        map.put(CompareDateFormate.ddhh, new int[] {Calendar.DATE, Calendar.HOUR_OF_DAY});
        
        map.put(CompareDateFormate.hhmmss, new int[] {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND});
        map.put(CompareDateFormate.hhmm, new int[] {Calendar.HOUR_OF_DAY, Calendar.MINUTE});
        map.put(CompareDateFormate.mmss, new int[] {Calendar.MINUTE, Calendar.SECOND});
    }
    
    /**
     * 根据CompareFields的格式（如只比较年月）比较两个日期先后，
     * 
     * @author mWX177641
     * @param date1 时间1
     * @param date2 时间2
     * @param cdf 比较规则
     * @return 若返回1，表示date1在date2之后，返回-1，表示date1在date2之前，0表示两者相等
     */
    public static int compare(Date date1, Date date2, CompareDateFormate cdf)
    {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        
        int[] form = map.get(cdf);
        for (int field : form)
        {
            int t1 = c1.get(field);
            int t2 = c2.get(field);
            if (t1 > t2)
            {
                return 1;
            }
            else if (t1 < t2)
            {
                return -1;
            }
        }
        return 0;
    }
    
    /**
     * 将字符串转换成日期长整形
     * 
     * @author mWX177641
     * @param time 日期字符串
     * @param pattern 解析的格式
     * @return 日期长整形
     */
    public static long timeStr2Long(String time, String pattern)
    {
        return timeStr2Date(time, pattern).getTime();
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
     * 判断一个给定的时间theDate是不是在当前时间的showDays天之内 validate if the given date (dateString) is less days than the days before
     * now date.
     * 
     * @author zKF27348
     * @param theDate 给定的时间
     * @param showDays 间隔天数
     * @return true if validate
     */
    public static boolean isValidateTimeInDays(Date theDate, int showDays)
    {
        // now time stamp
        Calendar now = Calendar.getInstance();
        
        // time stamp given
        Calendar theTime = Calendar.getInstance();
        theTime.setTime(theDate);
        long millisBetween = now.getTimeInMillis() - theTime.getTimeInMillis();
        long days = (millisBetween % (1000 * 60 * 60 * 24) == 0) ? millisBetween / (1000 * 60 * 60 * 24)
            : millisBetween / (1000 * 60 * 60 * 24) + 1;
        if (days <= showDays)
        {
            return true;
        }
        return false;
    }
    
    /**
     * 
     * 判断d1是否在d2前面days天内 for REQ-925 at 2012-01-12
     * 
     * @author zKF42393
     * @param d1 时间1
     * @param d2 时间2
     * @param days 间隔天数
     * @return
     */
    public static boolean isInBeforeDays(Date d1, Date d2, int days)
    {
        days--;
        if (null == d1 || null == d2)
        {
            return false;
        }
        Date d1t = trunc(d1);
        Date d2t = trunc(d2);
        Calendar c = Calendar.getInstance();
        c.setTime(d1t);
        c.add(Calendar.DATE, days);
        Date newDate = c.getTime();
        
        // modify by zKF42393 at 2012-2-1 for WORK-6459 begin
        if (d2t.after(d1t) && newDate.after(d2t) || d1t.equals(d2t) || newDate.equals(d2t))
        {
            return true;
        }
        
        // modify by zKF42393 at 2012-2-1 for WORK-6459 end
        return false;
    }
    
    /**
     * 
     * 本方法用于比较 当前时间d1在失效时间d2的前N(days)天内，是的话返回true
     *
     * @author wangzejun
     * @param d1 当前时间
     * @param d2 失效时间
     * @param days 前N天内
     * @param 本方法精确到秒
     * @return
     */
    public static boolean isInBeforeDaysSecond(Date d1, Date d2, int days)
    {
        if (null == d1 || null == d2)
        {
            return false;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d1);
        c.add(Calendar.DATE, days);
        Date newDate = c.getTime();
        
        if (d2.after(d1) && newDate.after(d2) || d1.equals(d2) || newDate.equals(d2))
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * 
     * 截断日期输出到天 for REQ-925 at 2012-01-12
     * 
     * @author zKF42393
     * @param d 时间
     * @return 只精确到天的时间
     */
    public static Date trunc(Date d)
    {
        Calendar ca = Calendar.getInstance();
        ca.setTime(d);
        
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);
        
        return ca.getTime();
    }
    
    /**
     * 
     * 判断d1是否在d2前面minutes分钟内
     * 
     * @author c00206213
     * @param d1 时间1
     * @param d2 时间2
     * @param minutes 间隔时间
     * @return true：d1是在d2前面minutes分钟内
     */
    public static boolean isInBeforeMinutes(Date d1, Date d2, int minutes)
    {
        if (null == d1 || null == d2)
        {
            return false;
        }
        if (((d2.getTime() - d1.getTime()) / ONE_MINUTE_MILLISECONDS) > minutes)
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * 
     * 判断d1是否在d2前面minutes分钟内
     * 
     * @author xiongruntu
     * @param d1 时间1
     * @param d2 时间2
     * @param minutes 间隔时间
     * @return true：d1是在d2前面minutes分钟内
     */
    public static boolean isIncludeMinutes(Date d1, Date d2, int minutes)
    {
        if (null == d1 || null == d2)
        {
            return false;
        }
        if ((Math.abs((d2.getTime() - d1.getTime())) / ONE_MINUTE_MILLISECONDS) <= minutes)
        {
            return true;
        }
        
        return false;
    }
    
    // 小时数累计到了下一个小时
    public static boolean isNextHour(Date d1, Date d2)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(d1);
        Calendar c1 = Calendar.getInstance();
        c.setTime(d2);
        return (c1.get(Calendar.HOUR_OF_DAY) - c.get(Calendar.HOUR_OF_DAY)) == 1 ? true : false;
    }
    
    // 一小时内
    public static boolean isHourClude(Date d1, Date d2)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(d1);
        Calendar c1 = Calendar.getInstance();
        c.setTime(d2);
        return (c1.get(Calendar.HOUR_OF_DAY) - c.get(Calendar.HOUR_OF_DAY)) == 0 ? true : false;
    }
    
    // 返回分钟数
    public static int getMinutes(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (c.get(Calendar.MINUTE) % 2 == 1)
        {
            return c.get(Calendar.MINUTE) - 1;
        }
        return c.get(Calendar.MINUTE);
    }
    
    /**
     * 获取当月开始时间
     * 
     * @author mWX177641
     * @param date 时间
     * @return 当月开始时间
     */
    public static Date getBeginOfCurrentMonth(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        
        return c.getTime();
    }
    
    /**
     * 
     * 比较当前时间是否在开始时间和结束时间内
     * 
     * @author lWX149482
     * @param starttime 开始时间
     * @param endtime 结束时间
     * @param formater 格式类型
     * @return boolean true 在开始时间和结束时间内false不在开始时间和结束时间内
     */
    public static boolean isCurrTimeInBeginTimeAndEndTime(String starttime, String endtime, String formater)
    {
        Date startDate = formdate(starttime, formater);
        Date endDate = formdate(endtime, formater);
        Date current = new Date();
        if (current.after(startDate) && current.before(endDate))
        {
            return true;
        }
        return false;
    }
    
    /**
     * 获取当前时间（时间格式：yyyy-MM-dd）
     * 
     * @author mWX177641
     * @return 当前时间（yyyy-MM-dd）
     */
    public static String GetNowDate()
    {
        String temp_str = "";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        temp_str = sdf.format(dt);
        return temp_str;
    }
    
    /**
     * 转换时间格式（时间格式：yyyy-MM-dd）
     * 
     * @author hlf
     * @return 时间（yyyyMMdd）
     * @throws PortalException
     */
    public static String format(String date)
        throws PortalException
    {
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("yyyyMMdd");
        
        if (StrUtil.isEmpty(date))
        {
            return "";
        }
        
        try
        {
            return out.format(in.parse(date));
        }
        catch (ParseException e)
        {
            throw new PortalException("using [" + date + "] parse yyyyMMdd failed");
        }
    }
    
    /**
     * 转换时间格式（时间格式：yyyyMMdd）
     * 
     * @author hlf
     * @param date
     * @return 时间格式：yyyy-MM-dd
     */
    public static String format2(String date)
    {
        SimpleDateFormat in = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            if (StrUtil.isEmpty(date))
            {
                return "";
            }
            else
            {
                return out.format(in.parse(date));
            }
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException("using [" + date + "] parse yyyy-MM-dd failed");
        }
    }
    
    /**
     * 判断一个给定的时间theDate是不是在当前时间的showHours小时之内
     * 
     * @author lwx149482
     * @param theDate 日期
     * @param showHours 小时
     * @return true if validate
     */
    public static boolean isValidateTimeInHours(String theDate, int showHours)
    {
        if (StrUtil.isNotEmpty(theDate))
        {
            Date oldDate = formdate(theDate, StrUtil.valueOf(CompareDateFormate.yyyyMMddhhmmss));
            Calendar now = Calendar.getInstance();
            Calendar theTime = Calendar.getInstance();
            theTime.setTime(oldDate);
            DecimalFormat decimalFormat = new DecimalFormat(".##");
            double millisBetween = now.getTimeInMillis() - theTime.getTimeInMillis();
            double hours = Double.valueOf(decimalFormat.format(millisBetween / (1000 * 60 * 60)));
            if (hours <= showHours)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 根据时间格式,获取long型输入、或者当前时间的时间戳
     * 
     * @author mWX177641
     * @param format 时间格式
     * @return String 格式化后的时间戳
     */
    public static String getCurrentTime(Long timeStamp, String format)
    {
        Date date = null;
        if (null != timeStamp)
        {
            date = new Date(timeStamp);
        }
        else
        {
            date = new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale("EN"));
        return sdf.format(date);
    }
    
    /**
     * 
     * 获取当前时间（默认时间格式：yyyy-MM-dd HH:mm:ss）
     * 
     * @author lWX180672
     * @param formater 时间格式
     * @return 当前时间
     */
    public static String GetNowDate(String formater)
    {
        formater = (null == formater) ? "yyyy-MM-dd HH:mm:ss" : formater;
        String temp_str = "";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        temp_str = sdf.format(dt);
        return temp_str;
    }
    
//    /**
//     * 获取指定天数的开始时刻
//     * 
//     * @author wkf50567
//     * @param date Date
//     * @param days int
//     * @return Timestamp
//     */
//    public static Timestamp getBeginOfDay(Date date, int days)
//    {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        
//        // 日期增加
//        c.add(Calendar.DATE, days);
//        
//        c.set(Calendar.HOUR_OF_DAY, 0);
//        c.set(Calendar.MINUTE, 0);
//        c.set(Calendar.SECOND, 0);
//        c.set(Calendar.MILLISECOND, 0);
//        
//        return new Timestamp(c.getTimeInMillis());
//    }
    
    /**
     * 
     * 字符串改为UTC时间
     * 
     * @author dWX200057
     * @param localTime
     * @param localTimeFormat
     * @return
     */
    public static String local2UTC(String localTime)
    {
        if (StrUtil.isEmpty(localTime))
        {
            return null;
        }
        SimpleDateFormat localFormater = new SimpleDateFormat("yyyyMMddHHmmss");
        localFormater.setTimeZone(TimeZone.getDefault());
        Date curUTCDate = null;
        try
        {
            curUTCDate = localFormater.parse(localTime);
        }
        catch (ParseException e)
        {
            LOGGER.error("formatter error", e);
            return localTime;
        }
        return UTC_DATEFORMAT.format(curUTCDate);
    }
    
    /**
     * 
     * utc时间转成本地时间
     *
     * @author pangcongcong
     * @param utcTime
     * @return
     */
    public static String utc2Local(String utcTime)
    {
        if (StrUtil.isEmpty(utcTime))
        {
            return null;
        }
        SimpleDateFormat utcFormater = new SimpleDateFormat("yyyyMMddHHmmss");
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date curUTCDate = null;
        try
        {
            curUTCDate = utcFormater.parse(utcTime);
        }
        catch (ParseException e)
        {
            LOGGER.error("formatter error", e);
            return utcTime;
        }
        return LOCAL_DATEFORMAT.format(curUTCDate);
    }
    
    /**
     * 
     * 判断是否在当前时间之前
     *
     * @author pangcongcong
     * @param date
     * @return
     */
    public static boolean isBeforeNow(String date)
    {
        boolean falg = true;
        if (StrUtil.isNotEmpty(date))
        {
            long now = System.currentTimeMillis();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            long time = 0L;
            try
            {
                time = sdf.parse(date).getTime();
            }
            catch (ParseException e)
            {
                LOGGER.error("formatter error", e);
            }
            falg = time < now;
        }
        return falg;
    }
    
    /**
     * 
     * 指定日期添加天数
     * 
     * @author wWX190899
     * @param d 日期
     * @param days 天数
     * @return Date
     */
    public static Date addDay(Date d, double days)
    {
        Calendar ca = Calendar.getInstance();
        ca.setTime(d);
        
        final long DAY_TIME = 24 * 60 * 60 * 1000;
        long milliseconds = (long)(DAY_TIME * days);
        
        ca.add(Calendar.DAY_OF_MONTH, (int)(milliseconds / DAY_TIME));
        ca.add(Calendar.MILLISECOND, (int)(milliseconds % DAY_TIME));
        
        return ca.getTime();
    }
    
    /**
     * 
     * 指定日期添加分钟
     * 
     * @author wWX190899
     * @param d 日期
     * @param minutes
     * @return Date
     */
    public static Date addMinutes(Date d, int minutes)
    {
        Calendar ca = Calendar.getInstance();
        ca.setTime(d);

        ca.add(Calendar.MINUTE, minutes);

        return ca.getTime();
    }
    
    /**
     * 
     * 书签/笔记添加的时候，返回合法时间，不能小于最小配置时间和当前时间
     *
     * @author shanlingling
     * @param addTime 书签/笔记添加时间
     * @return
     */
    public static String transAddTimeForNoteOrMark(String addTime)
    {
        String returnAddTime = null;
        Date nowDate = new Date();
        try
        {
            Date date = timeStr2Date(addTime, YYYYMMDDHHMMSS_FORMAT);
            if (date.before(addTimeMinTime) || date.after(nowDate))
            {
                returnAddTime = format(nowDate, YYYYMMDDHHMMSS_FORMAT);
            }
            else
            {
                returnAddTime = addTime;
            }
        }
        catch (Exception e)
        {
            returnAddTime = format(nowDate, YYYYMMDDHHMMSS_FORMAT);
        }
        
        return returnAddTime;
    }
    
    
  
}
