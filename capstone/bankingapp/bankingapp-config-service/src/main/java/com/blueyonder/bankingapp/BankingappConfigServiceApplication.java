package com.blueyonder.bankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BankingappConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingappConfigServiceApplication.class, args);
	}

}
