package com.labs.sboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;


@SpringBootApplication
// @ComponentScan
// @Configuration
// @EnableAutoConfiguration
public class HelloWorldSbootApplication implements CommandLineRunner  {

	private static Logger log = LoggerFactory.getLogger(HelloWorldSbootApplication.class);

	@Autowired
	ApplicationContext ctx;

	public static void main(String[] args) {
		System.out.println("Before Launching...");
		SpringApplication.run(HelloWorldSbootApplication.class, args);
		System.out.println("After Launching...");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Spring Boot!!!");

		int count = ctx.getBeanDefinitionCount();
		System.out.println("No of Beans: " + count);

		log.info("No of Beans: " + count);
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
	}
}
