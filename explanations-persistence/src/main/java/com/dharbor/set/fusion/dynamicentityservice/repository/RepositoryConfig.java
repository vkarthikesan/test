package com.dharbor.set.fusion.dynamicentityservice.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import org.springframework.stereotype.Repository;
import com.dharbor.set.fusion.dynamicentityservice.model.*;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
         	config.exposeIdsFor(Message.class);
         	config.exposeIdsFor(TextContent.class);
         	config.exposeIdsFor(Explanation.class);
    }
}