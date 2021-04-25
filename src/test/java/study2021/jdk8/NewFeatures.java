package study2021.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Describe jdk1.8新特性
 * @Author wangzejun
 * @Date 2021/4/17 14:49
 */
public class NewFeatures {

    /**
    * jdk1.8之前：遍历, 从集合对象中获取用户ID集合
    */
    @Test
    public void beforeTest01(){
        List<UserInfo> userList = getUserInfoList();
        List<String> userIds = new ArrayList<>();
        for (UserInfo user : userList) {
            userIds.add(user.getUserId());
        }
        System.out.println(userIds);
    }

    /**
     * jdk1.8之后：遍历, 从集合对象中获取用户ID集合
     */
    @Test
    public void afterTest01(){
        List<UserInfo> userList = getUserInfoList();
        List<String> userIds = userList.stream().map(UserInfo::getUserId).collect(Collectors.toList());
        System.out.println(userIds);
    }

    /**
     * jdk1.8之前：过滤
     */
    @Test
    public void beforeTest02(){
        List<UserInfo> userList = getUserInfoList();
        List<String> userIds = new ArrayList<>();
        for (UserInfo user : userList) {
            if(user.getUserName() != null){
                userIds.add(user.getUserId());
            }
        }
        System.out.println(userIds);
    }

    /**
     * jdk1.8之后：过滤
     */
    @Test
    public void afterTest02(){
        List<UserInfo> userList = getUserInfoList();
        List<String> userIds = userList.stream().filter(t -> t.getUserName() != null).map(UserInfo::getUserId).collect(Collectors.toList());
        System.out.println(userIds);
    }

    /**
     * jdk1.8之后：删除重复内容
     */
    @Test
    public void afterTest03(){
        List<UserInfo> userList = getUserInfoList();
        Set<String> userIds = userList.stream().filter(t -> t.getUserId() != null).map(UserInfo::getUserId).collect(Collectors.toSet());
        System.out.println(userIds);
    }

    /**
     * jdk1.8之后：数据类型转换
     */
    @Test
    public void afterTest04(){
        List<Long> userIds = getUserIds();
        List<String> userIdStrs = userIds.stream().map(x -> x.toString()).collect(Collectors.toList());
        System.out.println(userIds);
    }

    /**
     * jdk1.8之后：数组转集合
     */
    @Test
    public void afterTest05(){
        //创建一个字符串数组
        String[] strArray = new String[]{"a","b","c"};
        //转换后的List 属于 java.util.ArrayList 能进行正常的增删查操作
        List<String> strList = Stream.of(strArray).collect(Collectors.toList());
        System.out.println(strList);
    }

    /**
    * 获取用户信息列表
    */
    private List<UserInfo> getUserInfoList() {
        List<UserInfo> userList = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("123");
        userInfo.setUserName("wzj");
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserId("456");
        userList.add(userInfo);
        userList.add(userInfo2);
        return userList;
    }

    /**
    * 获取用户信息列表
    */
    private List<Long> getUserIds() {
        List<Long> userIds = new ArrayList<>();
        userIds.add(123L);
        userIds.add(456L);
        return userIds;
    }
}
