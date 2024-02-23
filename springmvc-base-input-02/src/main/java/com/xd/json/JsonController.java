package com.xd.json;

import com.xd.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/json")
@Controller
@ResponseBody
public class JsonController {

    /**
     * 前端传json数据， 报错415 不支持的数据类型
     * 原因：java原生api，只支持路径参数和param参数，不支持json
     * 解决方案：导入json处理依赖，然后给handlerAdapter配置json转化器
     * @param person
     * @return
     */
    @PostMapping(value = "/data", consumes = "application/json")
    public String data(@RequestBody Person person) {
        System.out.println("person = " + person);
        return person.toString();
    }
}
