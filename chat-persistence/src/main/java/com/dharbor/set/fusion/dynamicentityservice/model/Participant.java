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
                name = "findByConversationIdAndParticipantType",
                def = "{'participantType':1 ,'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByConversationIdAndUserId",
                def = "{'userId':1 ,'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByIdNotAndConversationIdAndRemovedOrderByJoinedOnAsc",
                def = "{'joinedOn':1 ,'id':1 ,'removed':1 ,'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByIdAndConversationId",
                def = "{'conversationId':1 ,'id':1 }"
            ),
            @CompoundIndex(
                name = "findByConversationId",
                def = "{'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByConversationIdAndRemovedAndJoinedOnGreaterThanOrderByJoinedOnAsc",
                def = "{'joinedOn':1 ,'removed':1 ,'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByConversationIdOrderByJoinedOnAsc",
                def = "{'joinedOn':1 ,'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByConversationIdAndUserIdAndParticipantType",
                def = "{'participantType':1 ,'userId':1 ,'conversationId':1 }"
            )
        }
)
@Document
public @Data class Participant implements BaseEntity {

    @Id
    private String id;

 	private Long joinedOn = 0L;

 	private Date createdDate;

 	private Boolean removed = false;

    @NotBlank(message = "conversationId is required")
    @Length(max = 255)
 	private String conversationId;

 	private Date lastUpdateDate;

 	private ParticipantType participantType = ParticipantType.DEFAULT;

    @NotBlank(message = "userId is required")
    @Length(max = 255)
 	private String userId;


    public void onBeforeCreate() {
        Date sysDate = new Date();
        createdDate=sysDate;
        lastUpdateDate=sysDate;
    }

    public void onBeforeSave() {
        Date sysDate = new Date();
        lastUpdateDate=sysDate;
    }

}