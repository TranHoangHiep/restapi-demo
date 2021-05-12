package com.studying.restapidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("index")
    public void helloIndex(){
        System.out.println("Hello world this is index");

    }

    @GetMapping("")
    public void hello(){
        System.out.println("Hello world this is empty");
    }
}
