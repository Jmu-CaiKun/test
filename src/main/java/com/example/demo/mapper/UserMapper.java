package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select user_id, user_name, user_password, user_gender, user_age, user_phone_number from user")
    public List<User> list();

    public User getByUsernameAndPassword(User user);
}
