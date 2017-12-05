package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.Conversation;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "Conversation:")
@RepositoryRestResource
public interface ConversationRepository extends MongoRepository<Conversation, String>{
    Collection<Conversation> findByResourceIdAndLabel(
             @Param("resourceId") @RequestParam("resourceId") String resourceId,
             @Param("label") @RequestParam("label") String label
    );

    Collection<Conversation> findByResourceId(
             @Param("resourceId") @RequestParam("resourceId") String resourceId
    );

}