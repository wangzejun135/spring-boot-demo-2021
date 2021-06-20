package com.example.springbootdemo2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/4/18 12:10
 */
@Controller
public class IndexController {

    @GetMapping("/index002")
    public String index(ModelAndView modelAndView){
        return "index";
    }
}

