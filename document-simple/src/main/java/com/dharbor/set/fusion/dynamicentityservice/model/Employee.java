
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

@Document
public @Data class Employee implements BaseEntity {

    @Id
    private String id;

    @Length(max = 255)
 	private String lastName;

 	private Float defaultFloat = 100f;

 	private UUID generatedUuid = UUID.randomUUID();
 	public void setGeneratedUuid(UUID uuidValue) {}

 	private UUID employeeId;

 	private Date updatedDate;

 	private Long defaultLong = 1000L;

 	private Long salary = 0L;

    @DBRef
    @RestResource(exported = false)
 	private ProfilePicture picture;

    @NotBlank(message = "firstName is required")
    @Length(max = 255)
 	private String firstName;

 	private Date createdDate;

 	private Integer phoneNumber = 0;

 	private Float immovableAssets = 0.0f;

    @NotNull(message = "requiredUuid is required")
 	private UUID requiredUuid;

 	private Double netWorth = 0.0d;

    @Length(max = 255)
 	private String defaultString = "1000";

    @Length(max = 10)
 	private String lengthString;

    @Length(max = 10000)
 	private String largeString;

 	private Integer defaultInt = 100;

 	private Double defaultDouble = 1000d;


    public void onBeforeCreate() {
        Date sysDate = new Date();
        createdDate=sysDate;
        updatedDate=sysDate;
    }

    public void onBeforeSave() {
        Date sysDate = new Date();
        updatedDate=sysDate;
    }

}