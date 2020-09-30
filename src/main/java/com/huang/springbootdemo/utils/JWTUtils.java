package com.huang.springbootdemo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
  //指定加密算法
   public  static final String signature="hello";
   //生成token
    public static String getToken(Map<String,Object> map)
    {
        //指定过期时间
        Calendar instance= Calendar.getInstance();
        instance.add(Calendar.DATE,7);
        JWTCreator.Builder builder=JWT.create();
       //设置payload
        map.forEach((k,v)->{
        builder.withClaim(k,(String)v);
        });

      //设置过期时间和加密算法
      String token= builder
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(signature));
        return token;
}

    //验证token并返回一个验证对象
    public  static DecodedJWT verify(String token){
       return JWT.require(Algorithm.HMAC256(signature)).build().verify(token);

   }


}