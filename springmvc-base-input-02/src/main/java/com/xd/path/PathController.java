package com.xd.path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/path")
@ResponseBody
public class PathController {
    // 动态路径设置 {key} = *
    @RequestMapping("/{account}/{password}")
    public String login(@PathVariable String account, @PathVariable String password) {
        System.out.println("account = " + account);
        System.out.println("password = " + password);
        return account + password;
    }
}
