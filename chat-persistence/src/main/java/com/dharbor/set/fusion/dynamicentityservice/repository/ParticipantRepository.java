package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.Participant;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "Participant:")
@RepositoryRestResource
public interface ParticipantRepository extends MongoRepository<Participant, String>{
    Collection<Participant> findByConversationIdAndUserIdAndParticipantType(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("userId") @RequestParam("userId") String userId,
             @Param("participantType") @RequestParam("participantType") ParticipantType participantType
    );

    Collection<Participant> findByConversationIdAndUserId(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("userId") @RequestParam("userId") String userId
    );

    @RestResource(path="findByIdConversationRemove")
    List<Participant> findByIdNotAndConversationIdAndRemovedOrderByJoinedOnAsc(
             @Param("id") @RequestParam("id") String id,
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("removed") @RequestParam("removed") Boolean removed,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByConversationRemoveJoinedOn")
    List<Participant> findByConversationIdAndRemovedAndJoinedOnGreaterThanOrderByJoinedOnAsc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("removed") @RequestParam("removed") Boolean removed,
             @Param("joinedOn") @RequestParam("joinedOn") Long joinedOn,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByIdConversationRemoveJoinedOn")
    List<Participant> findByIdNotAndConversationIdAndRemovedAndJoinedOnGreaterThanOrderByJoinedOnAsc(
             @Param("id") @RequestParam("id") String id,
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("removed") @RequestParam("removed") Boolean removed,
             @Param("joinedOn") @RequestParam("joinedOn") Long joinedOn,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    Collection<Participant> findByConversationId(
             @Param("conversationId") @RequestParam("conversationId") String conversationId
    );

    Collection<Participant> findByConversationIdAndParticipantType(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("participantType") @RequestParam("participantType") ParticipantType participantType
    );

    Collection<Participant> findByIdAndConversationId(
             @Param("id") @RequestParam("id") String id,
             @Param("conversationId") @RequestParam("conversationId") String conversationId
    );

    List<Participant> findByConversationIdOrderByJoinedOnAsc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

}