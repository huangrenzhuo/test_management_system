package com.huang.springbootdemo.filters;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.huang.springbootdemo.utils.JWTUtils;
import com.huang.springbootdemo.utils.ResponseUtils;
import com.huang.springbootdemo.utils.Result;
import com.huang.springbootdemo.utils.ResultCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    @Override
    protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {

    }

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String _token = request.getHeader(JWTUtils.token_header);
        if (_token == null || !_token.startsWith(JWTUtils.token_prefix)) {
            response.setCharacterEncoding("UTF-8");
            Result<Void> result = new Result<>();
            ResponseUtils.FailResponse(response, ResultCode.USER_TOKEN_ERROR);//token为空或者不符合规范
            return;
        } else {
            String token = _token.substring(6);
            DecodedJWT verify;
            try {
                verify = JWTUtils.verify(token);
                String username = verify.getClaim("username").asString();
                if (username != null) {
                    UsernamePasswordAuthenticationToken au = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(au);
                }
            } catch (SignatureVerificationException e) {
                e.printStackTrace();
                ResponseUtils.FailResponse(response, ResultCode.USER_TOKEN_SIGNATURE);//签名错误
                return;
            } catch (TokenExpiredException e) {
                e.printStackTrace();
                ResponseUtils.FailResponse(response, ResultCode.USER_TOKEN_EXPIRED);//过期
                return;
            } catch (AlgorithmMismatchException e) {
                e.printStackTrace();
                ResponseUtils.FailResponse(response, ResultCode.USER_TOKEN_AlgorithmMis_Match);//算法错误
                return;
            } catch (Exception e) {
                e.printStackTrace();
                ResponseUtils.FailResponse(response,ResultCode.USER_TOKEN_Other_ERROR);//其他错误
                return;
            }

        }
        chain.doFilter(request, response);


    }
}
