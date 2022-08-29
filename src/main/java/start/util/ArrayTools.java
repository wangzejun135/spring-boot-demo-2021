package start.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数组工具类
 *
 * @author h00101670
 * @version [版本号, 2009-1-24]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ArrayTools {
    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(ArrayTools.class);

    /**
     * 比较两个字符串数组，返回第一个数组与第二个数组不同的元素数组
     *
     * @param array1 String[] 字符串1
     * @param array2 String[] 字符串2
     * @return String[] 返回两个字符串数组中不同的元素数组
     * @author mWX177641
     */
    public static String[] compare(String[] array1, String[] array2) {
        // 第一个数组为空，返回空
        if ((null == array1) || (0 == array1.length)) {
            return new String[0];
        }

        // 第二个数组为空，返回第一个数组
        if ((null == array2) || (0 == array2.length)) {
            return array1;
        }

        int index = -1;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < array1.length; i++) {
            index = inArray(array1[i], array2);
            if (-1 == index) {
                list.add(array1[i]);
            }
        }

        if (0 == list.size()) {
            return new String[0];
        }

        String[] diff = new String[list.size()];
        return (String[]) list.toArray(diff);
    }

    /**
     * 判断字符串是否在字符串数组中
     *
     * @param str  String 需要判断的字符串
     * @param strs String[] 被判断的字符串数组
     * @return int 如果字符串不在数组中，返回-1；否则返回该元素索引
     * @author mWX177641
     */
    public static int inArray(String str, String[] strs) {
        if ((null == str) || (null == strs)) {
            return -1;
        }

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(str)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 判断字符串是否在字符串数组中
     *
     * @param str  String 需要判断的字符串
     * @param strs String[] 被判断的字符串数组
     * @return boolean true:字符串在数组中 false：字符串不在数组中
     * @author mWX177641
     */
    public static boolean isInArray(String str, String[] strs) {
        return inArray(str, strs) != -1;
    }

    /**
     * 比较两个数组，以数组1为准，去掉数组1中存在，数组2中不存在的元素； 在数组1最后加上数组2中存在，数组1中不存在的原始 使用场景： 展示目录下的图书等列表时，轮循展示缓存中的内容ID数组和当前最新的内容ID数组进行比较
     * 去掉已删除的图书，加上未删除图书。
     *
     * @param array1 数组1
     * @param array2 数组2
     * @return String[] 重新组合后的数组
     * @author mWX177641
     */
    public static String[] sortArrays(String[] array1, String[] array2) {
        if (null == array1 || 0 == array1.length) {
            return array2;
        }

        if (null == array2 || 0 == array2.length) {
            return null;
        }

        Map<String, Integer> srcMap = new HashMap<String, Integer>(array2.length);
        String[] temp = new String[array2.length];
        String[] result = new String[array2.length];

        for (int i = 0; i < array2.length; i++) {
            srcMap.put(array2[i], Integer.valueOf(i));
            temp[i] = array2[i];
        }

        int pos = 0;
        for (int i = 0; i < array1.length; i++) {
            Integer index = (Integer) srcMap.remove(array1[i]);
            if (null != index) {
                result[pos++] = array1[i];
                temp[index.intValue()] = null;
            }
        }

        for (int i = 0; ((i < temp.length) && (pos < array2.length)); i++) {
            if (null != temp[i]) {
                result[pos++] = temp[i];
            }
        }

        return result;
    }

    /**
     * 随机轮循算法，从一组数组中随机取出N个元素，轮循到最前面
     *
     * @param bookIDs 图书数组
     * @param num     轮循个数
     * @return String[] 随机数
     * @author mWX177641
     */
    public static String[] randomRank(String[] bookIDs, int num) {
        if (null == bookIDs || 0 == bookIDs.length) {
            return null;
        }

        // 如果轮转个数大于数组长度，则设置为数组长度
        if (num >= bookIDs.length) {
            num = bookIDs.length;
        }

        List<String> list = new ArrayList<String>(Arrays.asList(bookIDs));
        List<String> reList = new ArrayList<String>(bookIDs.length);

        int index;
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < num; i++) {
            index = r.nextInt(list.size());
            String s = list.remove(index);
            reList.add(s);
        }

        // 把其他元素保存到新数组中
        reList.addAll(list);

        String[] ids = new String[reList.size()];
        return (String[]) reList.toArray(ids);
    }

    /**
     * 数组环形轮循
     *
     * @param bookIDs 图书ID
     * @param num     轮循个数
     * @return String[] 轮循后的数组
     * @author mWX177641
     */
    public static String[] loopRank(String[] bookIDs, int num) {
        if ((null == bookIDs) || (0 == bookIDs.length)) {
            return bookIDs;
        }

        // 如果轮转个数大于数组长度，则设置为1
        if (num >= bookIDs.length) {
            num = 1;
        }

        int length = bookIDs.length;
        String[] temp = new String[length];

        // 根据轮转个数进行轮转
        System.arraycopy(bookIDs, length - num, temp, 0, num);
        System.arraycopy(bookIDs, 0, temp, num, length - num);

        return temp;
    }

    /**
     * 随机从一组内容ID数组中取出一个元素
     *
     * @author mWX177641
     * @param bookIDs 内容id数组
     * @return String 随机元素
     */
    // public static String getRankMember(String[] bookIDs)
    // {
    // int length = bookIDs.length;
    //
    // java.util.Random r = new java.util.Random();
    //
    // // 获取随即一个元素 int x = java.lang.Math.abs(r.nextInt()) % length;
    // int x = getRandom(length, r);
    // return bookIDs[x];
    // }

    /**
     * 获取一个随机数
     *
     * @author mWX177641
     * @param length 随机数长度
     * @param r 随机类
     * @return 随机数
     */
    // private static int getRandom(int length, java.util.Random r)
    // {
    // int x;
    // x = r.nextInt(length);
    // return x;
    // }

    /**
     * 从指定数组中找到某字符串的位置，并返回从此位置共length个字符串的数组
     *
     * @param str    被查找的数组
     * @param find   被查找的字符串
     * @param length 截取的数组长度
     * @return String[]
     * @author mWX177641
     */
    public static String[] getSubList(String[] str, String find, int length) {
        int index = 0;

        for (int i = 0; i < str.length; i++) {
            if (find.equals(str[i])) {
                index = i;

                break;
            }
        }

        String[] subList = new String[length];
        System.arraycopy(str, index, subList, 0, length);

        return subList;
    }

    /**
     * 从指定数组中找到某字符串的位置，并返回从此位置到数组结尾的总数据个数
     *
     * @author mWX177641
     * @param str 被查找的数组
     * @param find 被查找的字符串
     * @return int
     */
//    public static int getSubCount(String[] str, String find)
//    {
//        int index = 0;
//        
//        for (int i = 0; i < str.length; i++)
//        {
//            if (find.equals(str[i]))
//            {
//                index = i;
//                
//                break;
//            }
//        }
//        
//        return str.length - index;
//    }

    /**
     * 从指定数组中找到某字符串的位置，并返回从其角标开始到加count之后的字符串
     *
     * @author mWX177641
     * @param str 被查找的数组
     * @param find 被查找的字符串
     * @param count 偏移量
     * @return String
     */
//    public static String getElement(String[] str, String find, int count)
//    {
//        int index = 0;
//        
//        for (int i = 0; i < str.length; i++)
//        {
//            if (find.equals(str[i]))
//            {
//                index = i;
//                
//                break;
//            }
//        }
//        
//        if ((str.length - index) > count)
//        {
//            return str[index + count];
//        }
//        else
//        {
//            return "";
//        }
//    }

    /**
     * 数组累加
     *
     * @param buf1 被加数组1
     * @param buf2 被加数组2
     * @return Object[]
     * @author mWX177641
     */
    public static Object[] arrayAddWay(Object[] buf1, Object[] buf2) {
        if (buf1 == null) {
            return buf2;
        }
        if (buf2 == null) {
            return buf1;
        }
        Object[] bufret = null;
        int len1 = buf1.length;
        int len2 = buf2.length;
        if (len1 + len2 > 0) {
            bufret = new Object[len1 + len2];
        }
        if (len1 > 0) {
            System.arraycopy(buf1, 0, bufret, 0, len1);
        }
        if (len2 > 0) {
            System.arraycopy(buf2, 0, bufret, len1, len2);
        }
        return bufret;
    }

    /**
     * 数组比较，删除相同的
     *
     * @param contentIDs 需要处理的数组
     * @param bookIDs    对比的数组
     * @return String[]
     * @author mWX177641
     */
    public static String[] getSpecialIDs(String[] contentIDs, String[] bookIDs) {
        Map<String, String> ht = new HashMap<String, String>();
        for (String str : contentIDs) {
            ht.put(str, str);
        }

        String[] temp = new String[bookIDs.length];
        int j = 0;
        for (int i = 0; i < bookIDs.length; i++) {
            if (ht.containsKey(bookIDs[i]) == false) {
                temp[j] = bookIDs[i];
                j++;
            }
        }
        return temp;
    }

    /**
     * 判断数组是否为空
     *
     * @param object 数组
     * @return true：数组为空 false：数组不为空
     * @author mWX177641
     */
    public static boolean isEmpty(Object[] object) {
        return (object == null || object.length <= 0) ? true : false;
    }

    /**
     * 判断数组是否不为空
     *
     * @param object 数组
     * @return true：数组不为空 false：数组为空
     * @author mWX177641
     */
    public static boolean isNotEmpty(Object[] object) {
        return (object == null || object.length <= 0) ? false : true;
    }

    /**
     * 将数组转换为字符串形式表示
     *
     * @param array 数组
     * @return 数组的字符串表示
     * @author c00126000
     */
    public static String arrayToString(Object[] array) {
        if (array == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (Object str : array) {
            if (result.length() > 1) {
                result.append(",");
            }
            result.append(str);
        }
        result.append("]");
        return result.toString();
    }

    /**
     * 数组根据一定长度len，分割为多个子数组
     *
     * @param list
     * @param len
     * @return
     * @author h00197702
     */
    public static <T> List<List<T>> splitList(List<T> list, int len) {
        int count = list.size() / len;

        // 存在不满len的
        if (0 != list.size() % len) {
            count++;
        }

        List<List<T>> ret = new ArrayList<List<T>>();

        for (int i = 0; i < count; i++) {
            List<T> subList = new ArrayList<T>();
            // 剩下的所有元素
            if (i == count - 1) {
                subList.addAll(list.subList(i * len, list.size()));
                ret.add(subList);
            } else {
                subList.addAll(list.subList(i * len, len * (i + 1)));
                ret.add(subList);
            }
        }
        return ret;
    }
}
