package com.xd.param;

import com.xd.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 直接接收
     * 名称相同，可以不传递，也不会报错
     * /param/data?name=root&age=18
     */
    @RequestMapping("/data")
    @ResponseBody
    public String data(String name, int age) {
        System.out.println("name = " + name + " ,age = " + age);
        return name + age;
    }

    /**
     * 注解指定
     * 可以指定必须传递
     * 也可以设置不必须传递，指定默认值
     * /param/data1?account=root&page=1 要求account必须传递，page可以不传，默认值1
     */
    @RequestMapping("/data1")
    @ResponseBody
    public String data1(@RequestParam(value = "account") String username, @RequestParam(required = false, defaultValue = "1") int age) {
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return username + age;
    }

    /**
     * 特殊情况，一个key对应多个值，使用集合接收，此时必须使用requestParam注解
     * /param/data2?hbs=dance&hbs=sing
     */
    @RequestMapping("/data2")
    @ResponseBody
    public String data2(@RequestParam List<String> hbs) {
        System.out.println("hbs = " + hbs);
        return hbs.toString();
    }

    /**
     * 使用实体对象接收前端传的数据，此时无法使用@RequestParam 属性名必须和参数名相同
     * /param/data3?name=xx&age=3
     */
    @RequestMapping("/data3")
    @ResponseBody
    public String data3(User user) {
        System.out.println("user = " + user);
        return user.toString();
    }
}
