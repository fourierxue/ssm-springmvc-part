package com.xd.jsp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {
    /**
     * 快速查找视图
     * 1、方法的返回值是字符串
     * 2、不能添加@ResponseBody注解
     * 3、返回值写对应视图名称
     * @return
     */
    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        request.setAttribute("data", "hello jsp !!");
        System.out.println("jspController.index");
        return "index";
    }

    /**
     * 转发 : 只能是项目下的资源
     * 1、方法返回值String
     * 2、不能添加@ResponseBody
     * 3、返回的字符串 forward:/转发地址
     */
    @GetMapping("/forward")
    public String forward() {
        System.out.println("JspController.forward");
        return "forward:/jsp/index";
    }

    /**
     * 重定向 : 可以是项目外的资源
     * 1、方法返回值String
     * 2、不能添加@ResponseBody
     * 3、返回字符串 redirect:/重定向地址
     */
    @GetMapping("/redirect")
    public String redirect() {
        System.out.println("JspController.redirect");
        return "redirect:/jsp/index";
    }

    @GetMapping("/redirect/baidu")
    public String redirectBaiDu() {
        System.out.println("JspController.redirect");
        System.out.println("JspController.redirectBaiDu");
        return "redirect:http://www.baidu.com";
    }
    /**
     * 路径细节[不使用mvc request reponse]
         * 转发是项目下的资源，路径：项目下的地址，忽略applicationContext
         * 重定向可以是项目外的资源，重定向属于二次请求，路径：项目下的地址必须是全地址/output/jsp/index，不能忽略applicationContext
     * 使用springmvc路径语法
         * "forward:路径|redirect:路径" 重定向：资源的地址也不需要写项目的根路径
         * 转发和重定向地址相同
     */
}
