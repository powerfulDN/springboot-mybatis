package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


// @ComponentScan("com.atguigu.dao") //扫描组件的
//@MapperScan("com.atguigu.dao") // 扫描接口的包，，生成dao代理对象
@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class MainApplcation {
    public static void main(String[] args) {
        SpringApplication.run(MainApplcation.class, args);
    }
}
