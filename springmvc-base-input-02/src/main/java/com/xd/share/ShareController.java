package com.xd.share;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 共享域对象获取
 * 常用共享域 1、request 一次请求或者转发
 *          2、session 同一个浏览器的多次请求
 *          3、servletContext 最大共享域
 */
@Controller
@RequestMapping("/share")
@ResponseBody
public class ShareController {
    // 方案一
    @Autowired
    private ServletContext servletContext;
    public String data(HttpServletRequest request,
                       HttpSession session) {
        return "ok";
    }

    //方案二：mvc提供的方法, 针对request共享域提供了四种：model，modelMap，map，modelAndView
    public void data1(Model model) {
        model.addAttribute("key", "value");
    }
    public void data2(ModelMap modelMap) {
        modelMap.addAttribute("key", "value");
    }
    public void data3(Map map) {
        map.put("key", "value");
    }
    public ModelAndView data4() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("key", "value");
        mv.setViewName("视图名"); //必须返回页面
        return mv;
    }
}
