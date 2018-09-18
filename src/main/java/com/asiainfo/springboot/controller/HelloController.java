package com.asiainfo.springboot.controller;

import com.asiainfo.springboot.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/sayhello")
    @ResponseBody
    public String sayHello() {
        return helloService.sayHello("孙总");
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", "欢迎使用thymeleaf模板引擎");
        model.addAttribute("users", Arrays.asList("zhansan", "lisi", "wangwu"));
        return "success";
    }

}
