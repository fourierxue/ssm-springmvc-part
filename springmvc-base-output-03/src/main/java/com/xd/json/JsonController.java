package com.xd.json;

import com.xd.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/json")
@Controller
public class JsonController {

    @RequestMapping("/data")
    @ResponseBody
    public User data() {
        User u = new User();
        u.setName("xdd");
        u.setAge(3);
        return u; // 会在handlerAdapter中转换成json返回，再加上@ResponseBody注解，会将json直接返回
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<User> data1() {
        User u = new User();
        u.setName("xdd");
        u.setAge(3);
        List<User> l = new ArrayList<>();
        l.add(u);
        return l;
    }
}
