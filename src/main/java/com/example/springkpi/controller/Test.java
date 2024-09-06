package com.example.springkpi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// defines controller and searches for endpoints
@Controller
public class Test {

    @GetMapping("/")
    @ResponseBody
    public String info() {
        return "NV";
    }
}
