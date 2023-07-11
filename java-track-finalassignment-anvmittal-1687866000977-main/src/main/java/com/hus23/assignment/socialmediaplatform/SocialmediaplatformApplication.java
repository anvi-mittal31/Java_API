package com.hus23.assignment.socialmediaplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hus23.assignment.socialmediaplatform")
public class SocialmediaplatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialmediaplatformApplication.class, args);
	}

}
