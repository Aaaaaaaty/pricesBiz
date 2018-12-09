package com.price.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TestController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "hello word";
    }



    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test11() {
        return "test";
    }
}
