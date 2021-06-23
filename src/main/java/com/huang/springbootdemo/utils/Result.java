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
        result.setMessage("success");
        return result;
    }

    //成功,有数据
    public static <V> Result<V> success(V data) {
        Result<V> result = new Result<>();
        result.code = ResultCode.SUCCESS.getCode();
        result.setMessage("success");
        result.data = data;
        return result;
    }

    //失败
    public static Result<Void> failure() {
        Result<Void> result = new Result<>();
        result.setCode(ResultCode.FAILURE.getCode());
        result.setMessage("failure");
        return result;
    }

    //失败,自定义数据
    public static Result<Void> failure(String message) {
        Result<Void> result = new Result<>();
        result.setCode(ResultCode.FAILURE.getCode());
        result.setMessage("failure");
        return result;
    }

    //失败，使用已定义枚举
    public static Result<Void> failure(ResultCode resultCode) {
        Result<Void> result = new Result<>();
        result.setCode(resultCode.getCode());
        result.setMessage("failure");
        return result;
    }

}
