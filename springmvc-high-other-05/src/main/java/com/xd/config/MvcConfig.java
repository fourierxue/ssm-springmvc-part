package com.xd.config;

import com.xd.interceptor.MyInterceptor;
import com.xd.interceptor.MyInterceptor1;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
@ComponentScan({"com.xd.controller", "com.xd.error"})
public class MvcConfig implements WebMvcConfigurer { //实现接口，简化配置，避免每个配置bean都需要通过@bean添加
    // 视图解析器指定前后缀

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    // 开启静态资源查找 -> handlermapping找不到对应的handler时查找静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置方案一：拦截所有请求
        //registry.addInterceptor(new MyInterceptor());
        // 配置方案二：指定地址拦截 支持*(一层字符串)或者**(多层字符串)
        //registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/data");
        // 配置方案三：排除拦截 排除的地址应该属于被拦截的地址
        //registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**").excludePathPatterns("/user/data1");

        //先声明的在外层，优先级高，限制性优先级高的pre，最后执行优先级高的post/complete
        registry.addInterceptor(new MyInterceptor());
        registry.addInterceptor(new MyInterceptor1());
    }
}
