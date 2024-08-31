package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;



@SpringBootApplication
@OpenAPIDefinition
@EnableFeignClients(basePackages = "com.app")
public class StudentServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceAppApplication.class, args);
	}

}
