package com.dharbor.set.fusion.dynamicentityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class DynamicPersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicPersistenceApplication.class, args);
	}
}