package com.xd.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @ControllerAdvice 可以返回逻辑视图，转发和重定向
 * @RestControllerAdvice 直接反回json字符串
 * NullPointerException
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 精准查找，或者查找父异常

    @ExceptionHandler(ArithmeticException.class)
    public Object arithmeticExceptionHandler(ArithmeticException e) {
        String msg = e.getMessage();
        System.out.println("msg = " + msg);
        return msg;
    }

    @ExceptionHandler(Exception.class)
    public Object nullPointerExceptionHandler(Exception e) {
        String msg = e.getMessage();
        System.out.println("msg = " + msg);
        return msg;
    }
}
