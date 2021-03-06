package com.dibas.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootAngularAppApplication {

	@RequestMapping
	public String welcome(){
		return "It's works!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularAppApplication.class, args);
	}

}
