package com.example.springbootdemo2021.controller;

import com.example.springbootdemo2021.entity.UserResponse;
import com.example.springbootdemo2021.model.UserDO;
import com.example.springbootdemo2021.service.IUserService;
import com.example.springbootdemo2021.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/17 21:55
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * 测试数据库
     */
    @PostMapping(path = "/test01")
    public String test(Long id) {
        long start = System.currentTimeMillis();
        int aa = 0;
        try{
            aa = userService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            System.out.println("test() has error");
        }
        System.out.println(aa);
        long end = System.currentTimeMillis();
        return "SUCCESS:" + (end - start);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
    * 测试本地数据库是否连接
    */
    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from t_user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry = iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }

    /**
     * 插入用户
     */
    @PostMapping(path = "/addUser")
    public UserResponse addUser(@RequestBody UserDO userDO) {
        UserResponse response = new UserResponse();
        try{
            String phone = userDO.getPhone();
            String name = userDO.getName();
            if (StrUtil.isEmpty(name)) {
                response.setStatus("false");
                response.setMessage("name is null");
                return response;
            }
            if (StrUtil.isEmpty(phone)) {
                response.setStatus("false");
                response.setMessage("phone is null");
                return response;
            }
            int result = userService.insert(userDO);
            if (result == 1) {
                response.setStatus("success");
                response.setMessage("Request successful");
                return response;
            }
        } catch (Exception e) {
            System.out.println("addUser() has error");
        }
        return response;
    }

    /**
     * 查询用户信息
     */
    @PostMapping(path = "/getUserInfo")
    public UserDO getUserInfo(@RequestBody UserDO userDO) {
        UserDO result = new UserDO();
        try{
            if (userDO.getId() == null) {
                result.setMessage("id is null");
            }
            result = userService.selectByPrimaryKey(userDO.getId());
            if (null != result) {
                result.setMessage("Request successful");
                return result;
            } else {
                result = new UserDO();
                result.setMessage("userInfo is not exist, please check id");
            }
        } catch (Exception e) {
            System.out.println("getUserInfo() has error");
            result.setMessage("userInfo is not exist");
            return result;
        }
        return result;
    }

    /**
     * 删除用户信息
     */
    @PostMapping(path = "/deleteUserInfo")
    public UserResponse deleteUserInfo(@RequestBody UserDO userDO) {
        UserResponse response = new UserResponse();
        try{
            int result = userService.deleteByPrimaryKey(userDO.getId());
            if (result == 1) {
                response.setStatus("success");
                response.setMessage("Request successful");
                return response;
            }
        } catch (Exception e) {
            System.out.println("deleteUserInfo() has error");
        }
        return null;
    }




}
