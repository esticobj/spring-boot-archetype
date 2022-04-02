package org.example.archetype;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("org.example.archetype.dao")
@EnableCaching
public class StartMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartMainApplication.class, args);
    }
}
