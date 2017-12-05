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
                name = "findByResourceId",
                def = "{'resourceId':1 }"
            ),
            @CompoundIndex(
                name = "countByUserId",
                def = "{'userId':1 }"
            ),
            @CompoundIndex(
                name = "findByUserIdAndSubjectAndNotificationDateLessThanOrderByNotificationDateDesc",
                def = "{'userId':1 ,'subject':1 ,'notificationDate':-1 }"
            )
        }
)
@Document
public @Data class EmailNotification implements BaseEntity {

    @Id
    private String id;

    @Length(max = 255)
 	private String resourceId;

    @DBRef
    @RestResource(exported = false)
 	private EmailNotificationMetadata metadata;

    @Length(max = 255)
 	private String senderUserId;

    @DBRef
    @RestResource(exported = false)
 	private NotificationPayload payload;

    @Length(max = 255)
 	private String subject;

    @Length(max = 255)
 	private String userId;

 	private Date notificationDate;


    public void onBeforeCreate() {
        Date sysDate = new Date();
        notificationDate=sysDate;
    }


}