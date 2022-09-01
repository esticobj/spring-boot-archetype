package org.example.archetype.controller;

import org.example.archetype.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/test")
    public String test() {
        return "test:" + helloService.getName();
    }
}
