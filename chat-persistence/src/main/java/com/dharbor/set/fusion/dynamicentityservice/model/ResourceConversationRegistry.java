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
                name = "findTop1ByUserIdAndResourceId",
                def = "{'userId':1 ,'resourceId':1 }"
            )
        }
)
@Document
public @Data class ResourceConversationRegistry implements BaseEntity {

    @Id
    private String id;

    @NotBlank(message = "appResourceId is required")
    @Length(max = 255)
 	private String appResourceId;

    @NotBlank(message = "resourceId is required")
    @Length(max = 255)
 	private String resourceId;

    @NotBlank(message = "conversationId is required")
    @Length(max = 255)
 	private String conversationId;

    @NotBlank(message = "userId is required")
    @Length(max = 255)
 	private String userId;

    @NotBlank(message = "resourceUUID is required")
    @Length(max = 255)
 	private String resourceUUID;



}