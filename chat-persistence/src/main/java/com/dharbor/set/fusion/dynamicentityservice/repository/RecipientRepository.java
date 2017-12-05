package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.Recipient;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "Recipient:")
@RepositoryRestResource
public interface RecipientRepository extends MongoRepository<Recipient, String>{
    Collection<Recipient> findByParticipantIdAndMessageId(
             @Param("participantId") @RequestParam("participantId") String participantId,
             @Param("messageId") @RequestParam("messageId") String messageId
    );

    Collection<Recipient> findByParticipantIdAndRecipientState(
             @Param("participantId") @RequestParam("participantId") String participantId,
             @Param("recipientState") @RequestParam("recipientState") RecipientState recipientState
    );

    Collection<Recipient> findByParticipantId(
             @Param("participantId") @RequestParam("participantId") String participantId
    );

    Long countByMessageIdAndParticipantIdAndRecipientState(
             @Param("messageId") @RequestParam("messageId") String messageId,
             @Param("participantId") @RequestParam("participantId") String participantId,
             @Param("recipientState") @RequestParam("recipientState") RecipientState recipientState
    );

    Long countByParticipantIdAndRecipientState(
             @Param("participantId") @RequestParam("participantId") String participantId,
             @Param("recipientState") @RequestParam("recipientState") RecipientState recipientState
    );

    Collection<Recipient> findByMessageIdAndParticipantIdAndRecipientState(
             @Param("messageId") @RequestParam("messageId") String messageId,
             @Param("participantId") @RequestParam("participantId") String participantId,
             @Param("recipientState") @RequestParam("recipientState") RecipientState recipientState
    );

    Long countByMessageIdAndRecipientState(
             @Param("messageId") @RequestParam("messageId") String messageId,
             @Param("recipientState") @RequestParam("recipientState") RecipientState recipientState
    );

}