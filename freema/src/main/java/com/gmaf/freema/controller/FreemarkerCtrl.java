package com.gmaf.freema.controller;

import com.gmaf.freema.utils.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FreemarkerCtrl {
    @Autowired
    private Resources resources;

    @RequestMapping("/test")
    public String test(ModelMap modelMap)
    {

        modelMap.addAttribute("resource",resources);
        modelMap.addAttribute("test",resources);
        modelMap.addAttribute("first","1");
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        modelMap.addAttribute("list",list);
        return "index";
    }
}
