package com.xd.controller;

import com.xd.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 接受用户数据，用户有校验注解
     * 1、正常给实体类属性添加校验注解
     * 2、handler（@Validated 对象）
     * 细节：param | json 校验注解都有效果
     *      json参数，还是需要加@RequestBody
     *
     * 如果不符合异常，直接向前端抛出异常，解决方案：
     * 接受错误绑定信息！自定义返回结果！
     * 捕捉绑定错误信息:
     *  1、handler（校验对象，BindingResult) 要求：bindingresult必须紧紧挨着校验对象
     *  2、通过bindingresult对象获取绑定错误
     * @return
     */
    @PostMapping("/register")
    public Object register(@Validated @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            Map map = new HashMap();
            map.put("code", 400);
            return map;
        }
        System.out.println("user = " + user);
        return user;
    }

    @GetMapping("/data")
    public String data() {
        String name = null;
        System.out.println("UserController.data");
        //name.toString();
        return "ok";
    }

    @GetMapping("/data1")
    public String data1() {
        System.out.println("UserController.data1");
        //int i = 1/0;
        return "ok";
    }

}
