package com.example.demo.exception;

import com.example.demo.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler { // 全局异常处理器;

    @ExceptionHandler(Exception.class) // 捕获哪个类型的异常 -- 捕获所有异常;
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.fail("对不起，出错了，请联系管理员！！！");
    }
}
