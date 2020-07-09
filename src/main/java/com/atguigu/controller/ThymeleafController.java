package com.atguigu.controller;

import com.atguigu.domain.A;
import com.atguigu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {

    @RequestMapping("/demo")
    public String demo(Model model){
        model.addAttribute("hello", "hello ,joker");

        //集合数据
        List<A> users = new ArrayList<A>();
        users.add(new A("张三","123","张三"));
        users.add(new A("李四","123","李四"));
        users.add(new A("王五","123","王五"));
        model.addAttribute("users",users);

        //Map定义
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("No","123");
        dataMap.put("address","深圳");
        model.addAttribute("dataMap",dataMap);


        //存储一个数组
        String[] names = {"张三","李四","王五"};
        model.addAttribute("names",names);

        return "demo1";
    }

}
