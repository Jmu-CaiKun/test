package com.example.demo.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Result;
import com.example.demo.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class CheckLoginInterceptor implements HandlerInterceptor { // 定义拦截器;
    @Override // 目标资源运行前，true运行，反之不运行;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        log.info("请求路径：{}", url);

        if(url.contains("login")){
            log.info("登录操作，放行");
            return true;
        }

        String jwt = request.getHeader("token");

        if(!StringUtils.hasLength(jwt)){ // jwt令牌为空;
            log.info("jwt令牌为空");
            String notLogin = JSONObject.toJSONString(Result.fail("NOT_LOGIN"));
            response.getWriter().write(notLogin);
            return false;
        }

        try {
            JWTUtils.parseJMT(jwt);
        }catch (Exception e){
            // e.printStackTrace();
            log.info("令牌解析失败;");
            String notLogin = JSONObject.toJSONString(Result.fail("NOT_LOGIN"));
            response.getWriter().write(notLogin);
            return false;
        }

        log.info("令牌合法");
        return true;
    }

    @Override // 目标资源运行后运行;
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("posthandle");
    }

    @Override // 视图渲染后，最后运行;
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
