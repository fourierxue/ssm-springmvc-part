package com.xd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @GetMapping("/data")
    public String data() {
        String name = null;
        System.out.println("OrderController.data");
        //name.toString();
        return "ok";
    }

    @GetMapping("/data1")
    public String data1() {
        System.out.println("OrderController.data1");
        //int i = 1/0;
        return "ok";
    }

}
