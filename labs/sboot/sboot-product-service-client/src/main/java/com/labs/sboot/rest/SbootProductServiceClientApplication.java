package com.labs.sboot.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class SbootProductServiceClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SbootProductServiceClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate client = new RestTemplate();

		String baseUrl = "http://localhost:8080/products";

		Product product = new Product(200, "SmartPhone", "iPhone 14", "Apple", 75000.0);

		System.out.println("********** Create Product ***********");
		// Create Product
		ResponseEntity<String> postResponse = client.postForEntity(baseUrl,product,String.class);
//		String postResponse = client.postForObject(baseUrl,product,String.class);
		System.out.println(postResponse.getStatusCode());
		System.out.println(postResponse.getBody());
		System.out.println(postResponse.getHeaders());

		System.out.println("********** List Products ***********");

		// Get All Products
		ResponseEntity<List> response = client.getForEntity(baseUrl, List.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.getHeaders().entrySet());

		System.out.println("********** Fetch Product ***********");
		// Get Product for given ID
		ResponseEntity<Product> getResponse = client.getForEntity(baseUrl + "/2", Product.class);
		System.out.println(getResponse.getBody());

		// Update Product
		System.out.println("********** Update Product ***********");
		client.put(baseUrl + "/2", Product.class);
		ResponseEntity<Product> getResponse1 = client.getForEntity(baseUrl + "/2", Product.class);
		System.out.println(getResponse1.getBody());

		System.out.println("********** Delete Product ***********");
		// Delete Product
		client.delete(baseUrl + "/2");
		ResponseEntity<Product> getResponse2 = client.getForEntity(baseUrl + "/2", Product.class);
		System.out.println(getResponse2.getBody());
	}
}
