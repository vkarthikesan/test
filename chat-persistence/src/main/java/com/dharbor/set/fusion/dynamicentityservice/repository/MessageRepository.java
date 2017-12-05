package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.Message;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "Message:")
@RepositoryRestResource
public interface MessageRepository extends MongoRepository<Message, String>{
    List<Message> findByConversationIdAndCreatedDateLessThanOrderByCreatedDateDesc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    Collection<Message> findByConversationIdAndCreatedDateGreaterThan(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate
    );

    Message findTop1ByConversationIdAndSeenAndMessageType(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("seen") @RequestParam("seen") Boolean seen,
             @Param("messageType") @RequestParam("messageType") MessageType messageType
    );

    List<Message> findByConversationIdAndCreatedDateGreaterThanOrderByCreatedDateAsc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    List<Message> findByConversationIdAndSeenAndMessageTypeAndCreatedDateLessThanOrderByCreatedDateDesc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("seen") @RequestParam("seen") Boolean seen,
             @Param("messageType") @RequestParam("messageType") MessageType messageType,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

}