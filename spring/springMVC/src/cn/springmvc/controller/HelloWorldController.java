package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hello")
public class HelloWorldController {
    @RequestMapping("/say")
    public String sayHello()
    {
        System.out.println("hello");
        return "hello";
    }
}
