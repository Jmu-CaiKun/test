package com.example.demo;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        // 生成JWT令牌;
        Map<String, Object> mp = new HashMap<>();
        mp.put("name", "zhangsan");
        mp.put("password", 123);
        String jwt = JWTUtils.generateJMT(mp);

        System.out.println(jwt);

        // 解析JWT令牌;
        Claims claims = JWTUtils.parseJMT(jwt);
        System.out.println(claims);

        User user = new User();
        user.setUserName("test");
        user.setUserPassword("1235");
        User login = userService.login(user);
        if(login == null) System.out.println("no");
        else System.out.println(login.toString());
    }

}
