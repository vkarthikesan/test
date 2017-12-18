package com.dharbor.set.fusion.dynamicentityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableDiscoveryClient
@SpringBootApplication
public class DynamicPersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicPersistenceApplication.class, args);
	}

     @Value("${application.default.timezone:UTC}")
     private String applicationTimezone;

	@PostConstruct
        void started() {
            TimeZone.setDefault(TimeZone.getTimeZone(applicationTimezone));
        }
}