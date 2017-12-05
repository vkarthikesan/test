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
                name = "findByConversationIdAndSeenAndMessageTypeAndCreatedDateLessThanOrderByCreatedDateDesc",
                def = "{'createdDate':-1 ,'messageType':1 ,'conversationId':1 ,'seen':1 }"
            ),
            @CompoundIndex(
                name = "findTop1ByConversationIdAndSeenAndMessageType",
                def = "{'messageType':1 ,'conversationId':1 ,'seen':1 }"
            ),
            @CompoundIndex(
                name = "findByConversationIdAndCreatedDateLessThanOrderByCreatedDateDesc",
                def = "{'conversationId':1 ,'createdDate':-1 }"
            ),
            @CompoundIndex(
                name = "findByConversationIdAndCreatedDateGreaterThanOrderByCreatedDateAsc",
                def = "{'conversationId':1 ,'createdDate':1 }"
            )
        }
)
@Document
public @Data class Message implements BaseEntity {

    @Id
    private String id;

    @Length(max = 255)
 	private String joinRequestId;

 	private Boolean deleted = false;

 	private Date createdDate;

    @NotNull(message = "messageType is required")
 	private MessageType messageType;

 	private Boolean edited = false;

    @DBRef
    @RestResource(exported = false)
 	private Participant sender;

    @NotBlank(message = "conversationId is required")
    @Length(max = 255)
 	private String conversationId;

 	private Date lastUpdateDate;

    @NotNull(message = "contentType is required")
 	private ContentType contentType;

 	private Boolean seen = false;


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