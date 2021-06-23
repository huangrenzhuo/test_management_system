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
        result.setMessage("success");
        response.getWriter().print(JSON.toJSONString(result));
    }

    public static void FailResponse(HttpServletResponse response,String string) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        Result<Void> result = new Result<>();
        result.setCode(ResultCode.FAILURE.getCode());
        result.setMessage(string);
        response.getWriter().print(JSON.toJSONString(result));
    }
}
