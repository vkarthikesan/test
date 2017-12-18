package com.dharbor.set.fusion.dynamicentityservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;

import com.dharbor.set.fusion.dynamicentityservice.model.*;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Autowired
	private ApplicationContext context;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
         	config.exposeIdsFor(PPKUuidWithIdField.class);
         	config.exposeIdsFor(AllDataTypes.class);
         	config.exposeIdsFor(PPKLong.class);
         	config.exposeIdsFor(Entity2WithEmbeddedEntity.class);
         	config.exposeIdsFor(PPKString.class);
         	config.exposeIdsFor(PPKUuid.class);
         	config.exposeIdsFor(Entity1WithEmbeddedEntity.class);
         	config.exposeIdsFor(PPKInteger.class);
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener listener) {
        Validator validator = context.getBean("mvcValidator", Validator.class);
        listener.addValidator("beforeSave", validator);
        listener.addValidator("beforeCreate", validator);
    }
}