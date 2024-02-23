package com.xd.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    /**
     * @RequestMapping 不要求必须/开头
     * 1、精准地址1个或多个 "user/login" {"user/login1", "user/login2}
     * 2、支持模糊匹配 *任意一层字符串 | **任意层字符串
     *          /user/*  -> /user/a  /user/b 都可以 /user/a/b不可以
     *          /user/** -> /user/a /user/a/a/a 都可以
     * @return
     */
    @RequestMapping("/user/login")
    public String login () {
        return null;
    }
}
