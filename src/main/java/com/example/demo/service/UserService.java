package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceImpl {

    // 需要注入数据层Bean对象;
    @Autowired
    private UserMapper userMapper;

    // 获取所有员工信息;
    @Override
    public List<User> list() {
        return userMapper.list();
    }

    /**
     * 根据用户名和密码查询用户;
     */
    @Override
    public User login(User user){
        return userMapper.getByUsernameAndPassword(user);
    }
}
