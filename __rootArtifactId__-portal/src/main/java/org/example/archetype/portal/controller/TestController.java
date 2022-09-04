package org.example.archetype.portal.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.archetype.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @DubboReference
    private HelloService helloService;

    @GetMapping("/test")
    public String test() {
        return "test:" + helloService.getName();
    }
}
