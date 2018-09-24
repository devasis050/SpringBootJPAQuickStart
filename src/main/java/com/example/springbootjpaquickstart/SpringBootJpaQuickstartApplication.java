package com.example.springbootjpaquickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.controller")
public class SpringBootJpaQuickstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaQuickstartApplication.class, args);
	}
	
}
