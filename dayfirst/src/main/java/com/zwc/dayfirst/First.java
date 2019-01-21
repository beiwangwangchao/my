package com.zwc.dayfirst;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class First {
    @Resource
    private FirstInterface firstInterface;
    @RequestMapping("/test")
    public String test()
    {return firstInterface.first() ;}
}

