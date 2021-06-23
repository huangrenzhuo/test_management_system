package com.huang.springbootdemo.utils;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private static final long serialVersionUID = -8037171286104362012L;

    private Integer code;

    private String message;

    private T data;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    //成功,无数据
    public static Result<Void> success() {
        Result<Void> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.message = ResultCode.SUCCESS.getMessage();
        return result;
    }

    //成功,有数据
    public static <V> Result<V> success(V data) {
        Result<V> result = new Result<>();
        result.code = ResultCode.SUCCESS.getCode();
        result.message = ResultCode.SUCCESS.getMessage();
        result.data = data;
        return result;
    }

    //Void是一个不可实例化的类
    //因为Void是一个不可实例化的类，如果方法返回值是Void类型，那么该方法只能返回null
    //失败
    public static Result<Void> failure() {
        Result<Void> result = new Result<>();
        result.setCode(ResultCode.FAILURE.getCode());
        result.message = ResultCode.FAILURE.getMessage();
        return result;
    }

    //自定义失败
    public static Result fail(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }


}
