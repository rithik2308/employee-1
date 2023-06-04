package com.spring.employeee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(title="Employee" , version="1.0.0"),
		servers= {@Server(url="http://localhost:8080" ),@Server(url="http://google.com")},
		tags= {@Tag(name="AddItems",description="Use this API to add data")}
		)
public class Employee1Application {

	public static void main(String[] args) {
		SpringApplication.run(Employee1Application.class, args);
	}

}
