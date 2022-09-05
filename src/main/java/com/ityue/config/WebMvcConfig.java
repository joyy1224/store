package com.ityue.config;

import com.ityue.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    LoginInterceptor loginInterceptor = new LoginInterceptor();
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> paths = new ArrayList<String>();

        paths.add("/bootstrap3/**");
        paths.add("/css/*");
        paths.add("/images/**");
        paths.add("/js/*");
        paths.add("/web/register.html");
        paths.add("/web/login.html");
        paths.add("/index.html");
        paths.add("/web/product.html");
        paths.add("/users/reg");
        paths.add("/users/login");

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(paths);
    }
}
