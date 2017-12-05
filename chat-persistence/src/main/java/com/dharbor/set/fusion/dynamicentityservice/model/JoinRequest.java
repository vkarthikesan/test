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
                name = "findByConversationId",
                def = "{'conversationId':1 }"
            )
        }
)
@Document
public @Data class JoinRequest implements BaseEntity {

    @Id
    private String id;

    @NotNull(message = "joinRequestType is required")
 	private JoinRequestType joinRequestType;

    @NotBlank(message = "targetParticipantId is required")
    @Length(max = 255)
 	private String targetParticipantId;

 	private Date createdDate;

    @NotNull(message = "joinState is required")
 	private JoinState joinState;

    @NotBlank(message = "conversationId is required")
    @Length(max = 255)
 	private String conversationId;

    @NotBlank(message = "sourceParticipantId is required")
    @Length(max = 255)
 	private String sourceParticipantId;

 	private Date responseDate;


    public void onBeforeCreate() {
        Date sysDate = new Date();
        createdDate=sysDate;
        responseDate=sysDate;
    }

    public void onBeforeSave() {
        Date sysDate = new Date();
        responseDate=sysDate;
    }

}