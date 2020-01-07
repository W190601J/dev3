package com.order.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//用于注册拦截器
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

//    @Bean
//    public LoginInterceptor createBean() {
//        return new LoginInterceptor();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
//        registry.addInterceptor(createBean())
        registry.addInterceptor(loginInterceptor)
        .addPathPatterns("/**");  //表示拦截所有的请求
        //.excludePathPatterns("/users");//排除在外的请求路径
    }
}
