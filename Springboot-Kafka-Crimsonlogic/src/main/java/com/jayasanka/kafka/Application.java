package com.jayasanka.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.jayasanka.kafka.config",
		"com.jayasanka.kafka.controller",
		"com.jayasanka.kafka.service",
		"com.jayasanka.kafka.process"
})
@Configuration
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
