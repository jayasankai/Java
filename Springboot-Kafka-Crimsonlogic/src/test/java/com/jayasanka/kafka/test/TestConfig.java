package com.jayasanka.kafka.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {
		"com.jayasanka.kafka.config",
		"com.jayasanka.kafka.controller",
		"com.jayasanka.kafka.service",
		"com.jayasanka.kafka.process"
})
public class TestConfig {

}
