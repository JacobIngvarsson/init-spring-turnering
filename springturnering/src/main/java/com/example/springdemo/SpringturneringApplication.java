package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.controller"})
public class SpringturneringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringturneringApplication.class, args);
	}

}
