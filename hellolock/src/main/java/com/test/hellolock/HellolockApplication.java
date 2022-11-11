package com.test.hellolock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.test.controller", "com.test.service"})
public class HellolockApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellolockApplication.class, args);
    }

}
