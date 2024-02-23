package com.xd.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * 执行handler之前调用
     * 编码格式设置，登录保护，权限处理
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 要调用的方法
     * @return true放行，false拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1.preHandle");
        return true;
    }

    /**
     * handler 执行完之后，调用的方法，只有prehandle返回true才会触发
     * 对结果进行处理，敏感词汇检查
     * @param request
     * @param response
     * @param handler
     * @param modelAndView 返回的视图和共享域数据
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1.postHandle");
    }

    /**
     * 整体处理完毕
     * @param request
     * @param response
     * @param handler
     * @param ex  handler报错的异常对象
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1.afterCompletion");
    }
}
