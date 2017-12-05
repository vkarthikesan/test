package com.dharbor.set.fusion.dynamicentityservice.model;

import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import java.util.Date;
import java.util.UUID;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@CompoundIndexes(
        value = {
            @CompoundIndex(
                name = "countByMessageIdAndRecipientState",
                def = "{'messageId':1 ,'recipientState':1 }"
            ),
            @CompoundIndex(
                name = "findByMessageIdAndParticipantIdAndRecipientState",
                def = "{'participantId':1 ,'messageId':1 ,'recipientState':1 }"
            ),
            @CompoundIndex(
                name = "findByParticipantId",
                def = "{'participantId':1 }"
            ),
            @CompoundIndex(
                name = "findByParticipantIdAndMessageId",
                def = "{'participantId':1 ,'messageId':1 }"
            ),
            @CompoundIndex(
                name = "countByParticipantIdAndRecipientState",
                def = "{'participantId':1 ,'recipientState':1 }"
            )
        }
)
@Document
public @Data class Recipient implements BaseEntity {

    @Id
    private String id;

    @NotBlank(message = "participantId is required")
    @Length(max = 255)
 	private String participantId;

    @NotBlank(message = "messageId is required")
    @Length(max = 255)
 	private String messageId;

    @NotNull(message = "recipientState is required")
 	private RecipientState recipientState;



}