package com.example.demo.service.impl;

import com.example.demo.pojo.User;

import java.util.List;

public interface UserServiceImpl {

    // 查询所有员工信息;
    public List<User> list();

    /**
     * 根据用户名和密码查询用户;
     */
    public User login(User user);
}
