package com.huang.springbootdemo.config;

import com.huang.springbootdemo.filters.JWTAuthorizationFilter;
import com.huang.springbootdemo.filters.JWTLoginFilter;
import com.huang.springbootdemo.service.MyUser.MyUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Resource
    public MyUserService myUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserService).passwordEncoder(passwordEncoder());
    }

    //将加密器放在容器中 没有自定义 直接new BCryptPasswordEncoder
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry
//                = http.authorizeRequests();
//        registry.requestMatchers(CorsUtils::isPreFlightRequest).permitAll();//让Spring security放行所有preflight request


        // http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // http.formLogin() // 表单方式
        // http.httpBasic() // HTTP Basic方式
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("login").permitAll()
                .antMatchers().hasAuthority("administrator")//只有拥有这个权限才可以访问
                .antMatchers().hasAnyAuthority(" responsible_man", "administrator")//拥有其中一个就可以访问
                .antMatchers().hasRole("")//基于角色的控制访问在service生成时前面要加ROLE_,这里不用加
                .antMatchers().hasAnyRole("")
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //让它绕过springsecurity过滤器链
        web.ignoring().antMatchers("/register");
    }
}
