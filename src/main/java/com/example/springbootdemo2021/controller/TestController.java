package com.example.springbootdemo2021.controller;

import com.example.springbootdemo2021.entity.UserResponse;
import com.example.springbootdemo2021.model.UserDO;
import com.example.springbootdemo2021.service.IUserService;
import com.example.springbootdemo2021.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/5/9 15:31
 */
@RestController
@RequestMapping("/api")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IUserService iUserService;

    /**
     * send message
     */
    @PostMapping(path = "/sendMessage")
    public void sendMessage() {
        try {
/*            if (Constant.MSG_TYPE.equals(type)) {
                logger.info("我是生成者");
            } else {
                logger.info("我是生成者");
            }*/
            iUserService.sendMessage();
        } catch (Exception e) {
            System.out.println("deleteUserInfo() has error");
        }
    }

}
