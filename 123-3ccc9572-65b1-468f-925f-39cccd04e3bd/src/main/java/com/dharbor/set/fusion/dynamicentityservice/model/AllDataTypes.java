/*Digital Harbor International, Inc. makes no representations or warranties with respect to the contents or use of this manual,
and specifically disclaims any express or implied warranties of merchantability or fitness for any particular purpose. Digital
Harbor, Inc. reserves the right to revise this publication and to make changes to its content, at any time, without obligation to
notify any person or entity of such revisions or changes. Digital Harbor International, Inc. makes no representations or
warranties with respect to any Digital Harbor software, and specifically disclaims any express or implied warranties of
merchantability or fitness for any particular purpose. There are no warranties that extend beyond the descriptions contained in
these paragraphs. No warranty may be created or extended by sales representatives or written sales materials. Digital Harbor,
Inc. reserves the right to make changes to any and all parts of Digital Harbor software, at any time, without any obligation to
notify any person or entity of such changes. Digital Harbor, Inc. shall not be liable for any loss of profit or any other commercial
damages, including but not limited to special, incidental, consequential, or other damages.

Copyright © 2002-2018, Digital Harbor, Inc. All rights reserved. No part of this publication, including its interior design and\
icons, may be reproduced, stored in a retrieval system, or transmitted in any form by any means, electronic, mechanical,
photocopying, recording, or otherwise, without written permission of Digital Harbor.*/

package com.dharbor.set.fusion.dynamicentityservice.model;

import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonInclude;
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
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public @Setter class AllDataTypes implements BaseEntity {

    AllDataTypes () {}

    @Id
    private String id;

    @JsonProperty("id")
    public String getId(){
        return this.id;
    }

 	private Double requiredAndDefaultDouble = 1000.11d;

 	@JsonProperty("requiredAndDefaultDouble")
    public Double getRequiredAndDefaultDouble (){
        return this.requiredAndDefaultDouble;
     }

    @NotNull(message = "requiredDate is required")
 	private Date requiredDate;

 	@JsonProperty("requiredDate")
    public Date getRequiredDate (){
        return this.requiredDate;
     }

 	private Date updatedDate;

 	@JsonProperty("updatedDate")
    public Date getUpdatedDate (){
        return this.updatedDate;
     }

 	private Date customDate;

 	@JsonProperty("customDate")
    public Date getCustomDate (){
        return this.customDate;
     }

 	private UUID requiredAndGeneratedUuid = UUID.randomUUID();
 	public void setRequiredAndGeneratedUuid(UUID uuidValue) {}

 	@JsonProperty("requiredAndGeneratedUuid")
    public UUID getRequiredAndGeneratedUuid (){
        return this.requiredAndGeneratedUuid;
     }

 	private Department defaultEnum = Department.EMPLOYEE;

 	@JsonProperty("defaultEnum")
    public Department getDefaultEnum (){
        return this.defaultEnum;
     }

 	private Integer requiredAndDefaultInteger = 100;

 	@JsonProperty("requiredAndDefaultInteger")
    public Integer getRequiredAndDefaultInteger (){
        return this.requiredAndDefaultInteger;
     }

 	private Integer defaultInteger = 100;

 	@JsonProperty("defaultInteger")
    public Integer getDefaultInteger (){
        return this.defaultInteger;
     }

 	private Date normalDate;

 	@JsonProperty("normalDate")
    public Date getNormalDate (){
        return this.normalDate;
     }

    @Length(max = 255)
 	private String maxLengthForIndexString;

 	@JsonProperty("maxLengthForIndexString")
    public String getMaxLengthForIndexString (){
        return this.maxLengthForIndexString;
     }

    @NotNull(message = "requiredUuid is required")
 	private UUID requiredUuid;

 	@JsonProperty("requiredUuid")
    public UUID getRequiredUuid (){
        return this.requiredUuid;
     }

    @Length(max = 10)
 	private String lengthString;

 	@JsonProperty("lengthString")
    public String getLengthString (){
        return this.lengthString;
     }

 	private Integer normalInteger = 0;

 	@JsonProperty("normalInteger")
    public Integer getNormalInteger (){
        return this.normalInteger;
     }

    @Length(max = 255)
 	private String requiredAndDefaultString = "Default String Value";

 	@JsonProperty("requiredAndDefaultString")
    public String getRequiredAndDefaultString (){
        return this.requiredAndDefaultString;
     }

    @NotNull(message = "requiredEnum is required")
 	private Department requiredEnum;

 	@JsonProperty("requiredEnum")
    public Department getRequiredEnum (){
        return this.requiredEnum;
     }

 	private Long normalLong = 0L;

 	@JsonProperty("normalLong")
    public Long getNormalLong (){
        return this.normalLong;
     }

    @NotNull(message = "normalEnum is required")
 	private Department normalEnum;

 	@JsonProperty("normalEnum")
    public Department getNormalEnum (){
        return this.normalEnum;
     }

    @NotNull(message = "requiredFloat is required")
 	private Float requiredFloat;

 	@JsonProperty("requiredFloat")
    public Float getRequiredFloat (){
        return this.requiredFloat;
     }

 	private Long defaultLong = 1000L;

 	@JsonProperty("defaultLong")
    public Long getDefaultLong (){
        return this.defaultLong;
     }

 	private Boolean normalBoolean = false;

 	@JsonProperty("normalBoolean")
    public Boolean getNormalBoolean (){
        return this.normalBoolean;
     }

    @Length(max = 255)
 	private String defaultString = "Default String Value";

 	@JsonProperty("defaultString")
    public String getDefaultString (){
        return this.defaultString;
     }

 	private List<Department> collectionEnum;

 	@JsonProperty("collectionEnum")
    public List<Department> getCollectionEnum (){
        return this.collectionEnum;
     }

 	private Double normalDouble = 0.0d;

 	@JsonProperty("normalDouble")
    public Double getNormalDouble (){
        return this.normalDouble;
     }

    @NotNull(message = "requiredInteger is required")
 	private Integer requiredInteger;

 	@JsonProperty("requiredInteger")
    public Integer getRequiredInteger (){
        return this.requiredInteger;
     }

 	private Float normalFloat = 0.0f;

 	@JsonProperty("normalFloat")
    public Float getNormalFloat (){
        return this.normalFloat;
     }

 	private Boolean requiredAndDefaultBoolean = true;

 	@JsonProperty("requiredAndDefaultBoolean")
    public Boolean getRequiredAndDefaultBoolean (){
        return this.requiredAndDefaultBoolean;
     }

 	private List<String> collectionString;

 	@JsonProperty("collectionString")
    public List<String> getCollectionString (){
        return this.collectionString;
     }

 	private Float defaultFloat = 100.11f;

 	@JsonProperty("defaultFloat")
    public Float getDefaultFloat (){
        return this.defaultFloat;
     }

 	private Department requiredAndDefaultEnum = Department.EMPLOYEE;

 	@JsonProperty("requiredAndDefaultEnum")
    public Department getRequiredAndDefaultEnum (){
        return this.requiredAndDefaultEnum;
     }

 	private UUID generatedUuid = UUID.randomUUID();
 	public void setGeneratedUuid(UUID uuidValue) {}

 	@JsonProperty("generatedUuid")
    public UUID getGeneratedUuid (){
        return this.generatedUuid;
     }

 	private Long requiredAndDefaultLong = 1000L;

 	@JsonProperty("requiredAndDefaultLong")
    public Long getRequiredAndDefaultLong (){
        return this.requiredAndDefaultLong;
     }

    @NotNull(message = "requiredBoolean is required")
 	private Boolean requiredBoolean;

 	@JsonProperty("requiredBoolean")
    public Boolean getRequiredBoolean (){
        return this.requiredBoolean;
     }

    @Length(max = 256)
 	private String minLengthForNoIndexString;

 	@JsonProperty("minLengthForNoIndexString")
    public String getMinLengthForNoIndexString (){
        return this.minLengthForNoIndexString;
     }

 	private List<EmbeddedProperties> collectionEmbeddedEntity;

 	@JsonProperty("collectionEmbeddedEntity")
    public List<EmbeddedProperties> getCollectionEmbeddedEntity (){
        return this.collectionEmbeddedEntity;
     }

    @NotNull(message = "requiredLong is required")
 	private Long requiredLong;

 	@JsonProperty("requiredLong")
    public Long getRequiredLong (){
        return this.requiredLong;
     }

    @Length(max = 255)
 	private String normalString;

 	@JsonProperty("normalString")
    public String getNormalString (){
        return this.normalString;
     }

    @Length(max = 10000)
 	private String largeString;

 	@JsonProperty("largeString")
    public String getLargeString (){
        return this.largeString;
     }

 	private Double defaultDouble = 1000.11d;

 	@JsonProperty("defaultDouble")
    public Double getDefaultDouble (){
        return this.defaultDouble;
     }

 	private Map<String, Department> mapString;

 	@JsonProperty("mapString")
    public Map<String, Department> getMapString (){
        return this.mapString;
     }

 	private Date createdAndUpdatedDate;

 	@JsonProperty("createdAndUpdatedDate")
    public Date getCreatedAndUpdatedDate (){
        return this.createdAndUpdatedDate;
     }

 	private Boolean defaultBoolean = true;

 	@JsonProperty("defaultBoolean")
    public Boolean getDefaultBoolean (){
        return this.defaultBoolean;
     }

 	private UUID normalUuid;

 	@JsonProperty("normalUuid")
    public UUID getNormalUuid (){
        return this.normalUuid;
     }

    @NotBlank(message = "requiredString is required")
    @Length(max = 255)
 	private String requiredString;

 	@JsonProperty("requiredString")
    public String getRequiredString (){
        return this.requiredString;
     }

 	private Date requiredAndUpdatedDate;

 	@JsonProperty("requiredAndUpdatedDate")
    public Date getRequiredAndUpdatedDate (){
        return this.requiredAndUpdatedDate;
     }

    @NotNull(message = "requiredDouble is required")
 	private Double requiredDouble;

 	@JsonProperty("requiredDouble")
    public Double getRequiredDouble (){
        return this.requiredDouble;
     }

 	private Float requiredAndDefaultFloat = 100.11f;

 	@JsonProperty("requiredAndDefaultFloat")
    public Float getRequiredAndDefaultFloat (){
        return this.requiredAndDefaultFloat;
     }

 	private Date createdDate;

 	@JsonProperty("createdDate")
    public Date getCreatedDate (){
        return this.createdDate;
     }

 	private List<Address> collectionEntity;

 	@JsonProperty("collectionEntity")
    public List<Address> getCollectionEntity (){
        return this.collectionEntity;
     }

 	private Date requiredAndCreatedDate;

 	@JsonProperty("requiredAndCreatedDate")
    public Date getRequiredAndCreatedDate (){
        return this.requiredAndCreatedDate;
     }


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