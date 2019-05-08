package com.seniorproject.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ServerApplication.class, args);
		System.out.println("Contains" + context.containsBeanDefinition("userRepository"));
	}

}
