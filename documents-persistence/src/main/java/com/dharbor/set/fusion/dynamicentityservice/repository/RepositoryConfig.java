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
         	config.exposeIdsFor(VersionMetadata.class);
         	config.exposeIdsFor(DocumentVersion.class);
         	config.exposeIdsFor(DocumentMetadata.class);
         	config.exposeIdsFor(ResourceDocumentInfo.class);
         	config.exposeIdsFor(ResourceDocument.class);
         	config.exposeIdsFor(DocumentGroup.class);
         	config.exposeIdsFor(Document.class);
         	config.exposeIdsFor(UserSettings.class);
    }
}