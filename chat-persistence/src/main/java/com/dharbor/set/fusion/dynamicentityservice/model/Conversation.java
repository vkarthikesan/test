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
                name = "findByResourceIdAndLabel",
                def = "{'resourceId':1 ,'label':1 }"
            ),
            @CompoundIndex(
                name = "findByResourceId",
                def = "{'resourceId':1 }"
            )
        }
)
@Document
public @Data class Conversation implements BaseEntity {

    @Id
    private String id;

 	private ConversationType conversationType = ConversationType.PUBLIC;

    @NotBlank(message = "resourceId is required")
    @Length(max = 255)
 	private String resourceId;

    @NotBlank(message = "appResourceId is required")
    @Length(max = 255)
 	private String appResourceId;

 	private Date createdDate;

 	private Date lastUpdateDate;

    @NotBlank(message = "label is required")
    @Length(max = 255)
 	private String label;

    @NotBlank(message = "resourceUUID is required")
    @Length(max = 255)
 	private String resourceUUID;


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