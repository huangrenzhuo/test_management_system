package com.huang.springbootdemo.utils;


import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {
    public static void SuccessResponse(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        Result<Void> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        response.getWriter().print(JSON.toJSONString(result));
    }

    public static void FailResponse(HttpServletResponse response,ResultCode resultCode) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        Result<Void> result = new Result<>();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        response.getWriter().print(JSON.toJSONString(result));
    }

    public static void FailResponse(HttpServletResponse response,Integer code, String string) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        Result<Void> result = new Result<>();
        result.setCode(code);
        result.setMessage(string);
        response.getWriter().print(JSON.toJSONString(result));
    }
}
