package com.labs.scloud.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudServiceDiscoveryApplication implements CommandLineRunner {

	@Autowired
	DiscoveryClient client;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServiceDiscoveryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(client);

		for(String serviceName: client.getServices()) {
			System.out.println(serviceName);
		}

		RestTemplate restClient = new RestTemplate();

		List<ServiceInstance> serviceInstances = client.getInstances("registration-service");
		for(ServiceInstance serInstance: serviceInstances) {
			String baseUri = serInstance.getUri().toString() + "/products";
			System.out.println(baseUri);

			// List Products
			ResponseEntity<List> response = restClient.getForEntity(baseUri, List.class);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
		}
	}
}
