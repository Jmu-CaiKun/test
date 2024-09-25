package com.example.demo.pojo;


import com.example.demo.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String userGender;
    private Integer userAge;
    private String userPhoneNumber;

}
