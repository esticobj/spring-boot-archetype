package org.example.archetype;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.archetype.dao")
public class StartMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartMainApplication.class, args);
    }
}
