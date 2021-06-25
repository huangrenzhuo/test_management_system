package com.huang.springbootdemo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static List<Integer> jsonToIntList(String str){
//        JSONArray parseArray = JSON.parseArray(str);
//        List<Integer> list = new ArrayList<Integer>();
//        list = JSON.parseArray(str, Integer.class);
        return JSON.parseArray(str, Integer.class);
    }
    public static String intListToJson(List<Integer> intList){

        return JSON.toJSONString(intList);
    }
}
