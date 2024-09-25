package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int code;
    private String message;
    private Object data;

    public Result(Object data) {
        this.code = 200;
        this.message = "success";
        this.data = data;
    }

    public Result(Object data, boolean success, String message) {
        if (success) {
            this.code = 200;
            this.message = "success";
        } else {
            this.code = 500;
            this.message = message;
        }
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public static Result success(Object data) {
        return new Result(data);
    }

    public static Result fail(String message) {
        return new Result(500, message);
    }

    public static Result fail(int code, String message) {
        return new Result(code, message);
    }
}

