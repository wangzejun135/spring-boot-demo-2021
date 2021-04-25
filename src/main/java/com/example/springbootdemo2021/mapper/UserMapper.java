package com.example.springbootdemo2021.mapper;

import com.example.springbootdemo2021.model.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/17 21:32
 */
@Component
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDO userDO);

    UserDO selectByPrimaryKey(Long id);

    int updatePhone(@Param("id") Long id, @Param("phone") String phone);
}
