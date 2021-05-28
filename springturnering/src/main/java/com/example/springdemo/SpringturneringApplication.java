package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
@ComponentScan({"com.example.controller", "com.example.services", "com.example.repositories"})
public class SpringturneringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringturneringApplication.class, args);
	}

	
	@Bean
	public Docket swaggerConfiguration() {
		// Returns a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(regex("/api.*"))
				.apis(RequestHandlerSelectors.basePackage("com.example"))
				.build()
				.apiInfo(apiDetails());
		
	}
	
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Players Api",
				"Tournament tracking API",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact(
						"Jacob Ingvarsson", 
						"https://jacobingvarsson.com", 
						"jacob.ingvarsson@gmail.com"),
				"API License",
				"https://jacob.ingvarsson.com",
				Collections.emptyList());
	}
}
