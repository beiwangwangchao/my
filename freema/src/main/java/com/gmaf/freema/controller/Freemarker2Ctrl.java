package com.gmaf.freema.controller;

import com.gmaf.freema.utils.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class Freemarker2Ctrl {
    @Autowired
    private Resources resources;

    @RequestMapping("/test2/test")
    public String test(HttpServletRequest httpServletRequest)
    {
        return httpServletRequest.getContextPath();

    }
}
