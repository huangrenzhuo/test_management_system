package com.huang.springbootdemo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    //指定加密算法
    public static final String signature = "hello";

    public static final String token_header = "Authorization";

    public static final String token_prefix = "Bearer";

    public static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    //生成token
    public static String getToken(Map<String, Object> map) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);//单位是毫秒
        JWTCreator.Builder builder = JWT.create();
        //设置payload   负载中不要放敏感信息 放用户名就可以了
        map.forEach((k, v) -> {
            builder.withClaim(k, (String) v);
        });

        //设置过期时间和加密算法
        String token = builder
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(signature));
        return token;
    }

    //验证token并返回一个验证对象
    public static DecodedJWT verify(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(signature))
                    .build();//使用加密时使用的前面进行解密
            jwt = verifier.verify(token);//将得到的加密字符串token传入
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            System.out.println("签名错误");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            System.out.println("token过期");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            System.out.println("token算法不一致");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("token无效");
        }
        return jwt;
    }
}

