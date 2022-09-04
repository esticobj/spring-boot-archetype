package org.example.archetype.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.archetype.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@DubboService
@RefreshScope
public class HelloServiceImpl implements HelloService {

    @Value("${test.name:aaa}")
    private String name;

    @Override
    public String say(String msg) {
        return "Hello " + msg;
    }

    @Override
    public String getName() {
        return name;
    }
}
