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
         	config.exposeIdsFor(CPK_Custom_Generated_Integer.class);
         	config.exposeIdsFor(ChildEntityWithSoftDelete.class);
         	config.exposeIdsFor(SGPKLong.class);
         	config.exposeIdsFor(OneToOneBiDirectionalChild.class);
         	config.exposeIdsFor(OneToOneBiDirectionalParent.class);
         	config.exposeIdsFor(ManyToOneCascadeMerge.class);
         	config.exposeIdsFor(CPKUuidUuid.class);
         	config.exposeIdsFor(CPKUuidUuid.CompositeKey.class);
         	config.exposeIdsFor(OneToOneCascadeAll.class);
         	config.exposeIdsFor(ManyToManyChild.class);
         	config.exposeIdsFor(Manager.class);
         	config.exposeIdsFor(PPKUuidWithIdField.class);
         	config.exposeIdsFor(OTOCascadeAllWithPPKForParentAndChild.class);
         	config.exposeIdsFor(OneToOneAllJpaOptions.class);
         	config.exposeIdsFor(OneToManyCascadeMerge.class);
         	config.exposeIdsFor(AllDataTypes.class);
         	config.exposeIdsFor(SGPKUuidWithIdField.class);
         	config.exposeIdsFor(SGPKUuid.class);
         	config.exposeIdsFor(OneToOneSelfReference.class);
         	config.exposeIdsFor(CPKUuidUuidGenerated.class);
         	config.exposeIdsFor(CPKUuidUuidGenerated.CompositeKey.class);
         	config.exposeIdsFor(PPKString.class);
         	config.exposeIdsFor(CPKUuidLong.class);
         	config.exposeIdsFor(CPKUuidLong.CompositeKey.class);
         	config.exposeIdsFor(CustomQueryAlias.class);
         	config.exposeIdsFor(OTOCascadeAllWithProvidedPrimaryKeyForParent.class);
         	config.exposeIdsFor(OTOCascadeAllWithPPKForChild.class);
         	config.exposeIdsFor(CPKLongString.class);
         	config.exposeIdsFor(CPKLongString.CompositeKey.class);
         	config.exposeIdsFor(ParentEntityWithSoftDelete.class);
         	config.exposeIdsFor(ProfilePicture.class);
         	config.exposeIdsFor(ProfilePictureWithProvidedPrimaryKey.class);
         	config.exposeIdsFor(ManyToManyParent.class);
         	config.exposeIdsFor(PPKLong.class);
         	config.exposeIdsFor(PPKUuid.class);
         	config.exposeIdsFor(SoftDeleteEntity.class);
         	config.exposeIdsFor(PPKInteger.class);
    }
}