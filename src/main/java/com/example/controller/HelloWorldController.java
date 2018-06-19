package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author zhuanghuang@corp.netease.com
 * @date 2018/6/19
 */

@Controller
public class HelloWorldController {

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String print(Model model) {
        model.addAttribute("info", "welcome to Spring MVC");
        return "helloworld";
    }
}
