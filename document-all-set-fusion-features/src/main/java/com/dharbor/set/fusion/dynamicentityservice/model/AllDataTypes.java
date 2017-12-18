
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
                name = "findByNormalLong",
                def = "{'normalLong':1 }"
            ),
            @CompoundIndex(
                name = "findByLengthString",
                def = "{'lengthString':1 }"
            ),
            @CompoundIndex(
                name = "findByDefaultIntegerAndDefaultLong",
                def = "{'defaultInteger':1 ,'defaultLong':1 }"
            ),
            @CompoundIndex(
                name = "findByNormalFloat",
                def = "{'normalFloat':1 }"
            ),
            @CompoundIndex(
                name = "findByNormalUuid",
                def = "{'normalUuid':1 }"
            ),
            @CompoundIndex(
                name = "findByNormalInteger",
                def = "{'normalInteger':1 }"
            ),
            @CompoundIndex(
                name = "findByNormalEnum",
                def = "{'normalEnum':1 }"
            ),
            @CompoundIndex(
                name = "findByNormalDate",
                def = "{'normalDate':1 }"
            ),
            @CompoundIndex(
                name = "findByMaxLengthForIndexString",
                def = "{'maxLengthForIndexString':1 }"
            ),
            @CompoundIndex(
                name = "queryFirst10ByNormalString",
                def = "{'normalString':1 }"
            ),
            @CompoundIndex(
                name = "findByNormalDouble",
                def = "{'normalDouble':1 }"
            ),
            @CompoundIndex(
                name = "findByNormalBoolean",
                def = "{'normalBoolean':1 }"
            )
        }
)
@Document
public @Data class AllDataTypes implements BaseEntity {

    @Id
    private String id;

 	private Float defaultFloat = 100.11f;

 	private Double requiredAndDefaultDouble = 1000.11d;

 	private Department requiredAndDefaultEnum = Department.EMPLOYEE;

 	private UUID generatedUuid = UUID.randomUUID();
 	public void setGeneratedUuid(UUID uuidValue) {}

 	private Long requiredAndDefaultLong = 1000L;

    @NotNull(message = "requiredDate is required")
 	private Date requiredDate;

 	private Date updatedDate;

 	private Date customDate;

 	private UUID requiredAndGeneratedUuid = UUID.randomUUID();
 	public void setRequiredAndGeneratedUuid(UUID uuidValue) {}

    @NotNull(message = "requiredBoolean is required")
 	private Boolean requiredBoolean;

    @Length(max = 256)
 	private String minLengthForNoIndexString;

 	private Department defaultEnum = Department.EMPLOYEE;

 	private Integer requiredAndDefaultInteger = 100;

    @NotNull(message = "requiredLong is required")
 	private Long requiredLong;

 	private Integer defaultInteger = 100;

 	private Date normalDate;

    @Length(max = 255)
 	private String maxLengthForIndexString;

    @NotNull(message = "requiredUuid is required")
 	private UUID requiredUuid;

    @Length(max = 10)
 	private String lengthString;

    @Length(max = 255)
 	private String normalString;

 	private Integer normalInteger = 0;

    @Length(max = 10000)
 	private String largeString;

 	private Double defaultDouble = 1000.11d;

    @Length(max = 255)
 	private String requiredAndDefaultString = "Default String Value";

 	private Date createdAndUpdatedDate;

    @NotNull(message = "requiredEnum is required")
 	private Department requiredEnum;

 	private Long normalLong = 0L;

    @NotNull(message = "normalEnum is required")
 	private Department normalEnum;

 	private Boolean defaultBoolean = true;

 	private UUID normalUuid;

    @NotNull(message = "requiredFloat is required")
 	private Float requiredFloat;

 	private Long defaultLong = 1000L;

    @NotBlank(message = "requiredString is required")
    @Length(max = 255)
 	private String requiredString;

 	private Date requiredAndUpdatedDate;

    @NotNull(message = "requiredDouble is required")
 	private Double requiredDouble;

 	private Boolean normalBoolean = false;

 	private Float requiredAndDefaultFloat = 100.11f;

 	private Date createdDate;

    @Length(max = 255)
 	private String defaultString = "Default String Value";

 	private Double normalDouble = 0.0d;

    @NotNull(message = "requiredInteger is required")
 	private Integer requiredInteger;

 	private Float normalFloat = 0.0f;

 	private Date requiredAndCreatedDate;

 	private Boolean requiredAndDefaultBoolean = true;


    public void onBeforeCreate() {
        Date sysDate = new Date();
        createdAndUpdatedDate=sysDate;
        createdDate=sysDate;
        requiredAndCreatedDate=sysDate;
        updatedDate=sysDate;
        createdAndUpdatedDate=sysDate;
        requiredAndUpdatedDate=sysDate;
    }

    public void onBeforeSave() {
        Date sysDate = new Date();
        updatedDate=sysDate;
        createdAndUpdatedDate=sysDate;
        requiredAndUpdatedDate=sysDate;
    }

}