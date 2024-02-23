package com.xd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@EnableWebMvc //给handlerAdapter配置了json转化器
@Configuration
@ComponentScan({"com.xd.param", "com.xd.path", "com.xd.json", "com.xd.cookie", "com.xd.header"})
public class MvcConfig implements WebMvcConfigurer {
//    @Bean
//    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
//        return new RequestMappingHandlerMapping();
//    }
//
//    @Bean
//    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
//        return new RequestMappingHandlerAdapter();
//    }
}
