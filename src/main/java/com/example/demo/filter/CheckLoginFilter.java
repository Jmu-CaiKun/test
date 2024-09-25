package com.example.demo.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Result;
import com.example.demo.utils.JWTUtils;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class CheckLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        log.info("请求路径：{}", url);

        if(url.contains("login")){
            log.info("登录操作，放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String jwt = req.getHeader("token");

        if(!StringUtils.hasLength(jwt)){ // jwt令牌为空;
            log.info("jwt令牌为空");
            String notLogin = JSONObject.toJSONString(Result.fail("NOT_LOGIN"));
            resp.getWriter().write(notLogin);
            return;
        }

        try {
            JWTUtils.parseJMT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("令牌解析失败;");
            String notLogin = JSONObject.toJSONString(Result.fail("NOT_LOGIN"));
            resp.getWriter().write(notLogin);
            return;
        }

        log.info("令牌合法");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
