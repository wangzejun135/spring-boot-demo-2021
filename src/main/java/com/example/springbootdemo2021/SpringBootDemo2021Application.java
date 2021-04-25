package com.example.springbootdemo2021;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.springbootdemo2021.mapper")
@SpringBootApplication
public class SpringBootDemo2021Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo2021Application.class, args);
    }

}
