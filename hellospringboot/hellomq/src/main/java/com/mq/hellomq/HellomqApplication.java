package com.mq.hellomq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mq"})
public class HellomqApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellomqApplication.class, args);
	}

}

