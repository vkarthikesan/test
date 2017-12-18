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
         	config.exposeIdsFor(SGPKUuidWithIdField.class);
         	config.exposeIdsFor(PPKString.class);
         	config.exposeIdsFor(OneToOneSelfReference.class);
         	config.exposeIdsFor(SoftDeleteEntity.class);
         	config.exposeIdsFor(CustomQueryAlias.class);
         	config.exposeIdsFor(SGPKString.class);
         	config.exposeIdsFor(AllDataTypes.class);
         	config.exposeIdsFor(CPKLongString.class);
         	config.exposeIdsFor(CPKLongString.CompositeKey.class);
         	config.exposeIdsFor(OneToOneBiDirectionalParent.class);
         	config.exposeIdsFor(CPKUuidUuid.class);
         	config.exposeIdsFor(CPKUuidUuid.CompositeKey.class);
         	config.exposeIdsFor(OTOWithProvidedPrimaryKeyForParent.class);
         	config.exposeIdsFor(OTOWithPPKForParentAndChild.class);
         	config.exposeIdsFor(OneToOneBiDirectionalChild.class);
         	config.exposeIdsFor(ProfilePicture.class);
         	config.exposeIdsFor(PPKUuidWithIdField.class);
         	config.exposeIdsFor(ProfilePictureWithProvidedPrimaryKey.class);
         	config.exposeIdsFor(PPKLong.class);
         	config.exposeIdsFor(PPKUuid.class);
         	config.exposeIdsFor(CPKUuidLong.class);
         	config.exposeIdsFor(CPKUuidLong.CompositeKey.class);
         	config.exposeIdsFor(OneToOne.class);
         	config.exposeIdsFor(PPKInteger.class);
         	config.exposeIdsFor(OTOWithPPKForChild.class);
         	config.exposeIdsFor(CPKUuidUuidGenerated.class);
         	config.exposeIdsFor(CPKUuidUuidGenerated.CompositeKey.class);
    }
}