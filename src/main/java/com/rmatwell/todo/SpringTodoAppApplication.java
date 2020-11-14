package com.rmatwell.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringTodoAppApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringTodoAppApplication.class, args);
	}

}
