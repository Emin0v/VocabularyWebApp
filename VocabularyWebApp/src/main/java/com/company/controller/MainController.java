package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET , value = "/main1")
    public String main(){
        return "main1";
    }

    @RequestMapping(method = RequestMethod.GET , value = "/start")
    public String start(){
        return "start";
    }
}
