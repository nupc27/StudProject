package com.project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudProjectApplication.class, args);
	}

}
