package com.example.demo.controller;


import com.example.demo.pojo.Result;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j // 打印日志;
@RestController
public class UserController {

    // 需要注入服务层Bean对象;
    @Autowired
    private UserService userService;

    @PostMapping("/hello")
    public Result list(){

        log.info("查询所有员工");
        List<User> list = userService.list();

        return Result.success(list);
    }

}
