package com.xd.api;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 使用原生api
 */
@Controller
public class ApiController {
    @Autowired
    private ServletContext servletContext;

    public void data(HttpServletResponse response,
                     HttpServletRequest request,
                     HttpSession session) {
        // ServletContext获取方式
        // 1、使用request或者session获取
        ServletContext servletContext = request.getServletContext();
        ServletContext servletContext1 = session.getServletContext();
        // 2、autowired注入

    }
}
