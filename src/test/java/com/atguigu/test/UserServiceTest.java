package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    DataSource dataSource;
    @Test
    public void findAll() {
        List<User> all = userService.findAll();

        all.forEach(System.out::println);
    }

    @Test
    public void setDataSource(){

        //  com.alibaba.druid.pool.DruidDataSource
        // com.zaxxer.hikari.HikariDataSource
        System.out.println("dataSource = " + dataSource.getClass());
    }
}