package com.dharbor.set.fusion.dynamicentityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableDiscoveryClient
@SpringBootApplication
@EnableMongoAuditing
public class DynamicPersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicPersistenceApplication.class, args);
	}

	@Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

     @Value("${application.default.timezone:UTC}")
     private String applicationTimezone;

   @PostConstruct
       void started() {
           TimeZone.setDefault(TimeZone.getTimeZone(applicationTimezone));
       }
}