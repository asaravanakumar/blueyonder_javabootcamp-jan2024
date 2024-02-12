package com.labs.sboot.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SbootRestLabsApplication implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(SbootRestLabsApplication.class);

	@Autowired
	ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(SbootRestLabsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(ctx);

		int count = ctx.getBeanDefinitionCount();
		log.info("No of Beans: " + count);

//		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

	}
}
