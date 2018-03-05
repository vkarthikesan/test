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

import java.io.Serializable;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import java.util.Date;
import java.util.UUID;
import java.util.List;
import java.util.Map;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;
import org.springframework.data.rest.core.annotation.RestResource;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(
        indexes = {
            @Index(
                name = "findByNormalLong",
                columnList = "normalLong"
            ),
            @Index(
                name = "findByNormalDateAfter",
                columnList = "normalDate"
            ),
            @Index(
                name = "findByNormalStringOrLengthString",
                columnList = "lengthString,normalString"
            ),
            @Index(
                name = "findByLengthString",
                columnList = "lengthString"
            ),
            @Index(
                name = "findByDefaultIntegerAndDefaultLong",
                columnList = "defaultInteger,defaultLong"
            ),
            @Index(
                name = "findByNormalFloat",
                columnList = "normalFloat"
            ),
            @Index(
                name = "findByNormalUuid",
                columnList = "normalUuid"
            ),
            @Index(
                name = "findByNormalStringNotLike",
                columnList = "normalString"
            ),
            @Index(
                name = "findByNormalInteger",
                columnList = "normalInteger"
            ),
            @Index(
                name = "findByNormalEnum",
                columnList = "normalEnum"
            ),
            @Index(
                name = "findByMaxLengthForIndexString",
                columnList = "maxLengthForIndexString"
            ),
            @Index(
                name = "findByNormalDouble",
                columnList = "normalDouble"
            ),
            @Index(
                name = "findByNormalBooleanIsTrue",
                columnList = "normalBoolean"
            )
        }
)
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public @Setter class AllDataTypes implements BaseEntity {

    AllDataTypes () {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("id")
    public Long getId() {return this.id;}

    @Length(max = 255)
    @Column(unique = true)
 	private String uniqueString;

    @JsonProperty("uniqueString")
    public String getUniqueString (){
        return this.uniqueString;
    }

 	private Float defaultFloat = 100.11f;

    @JsonProperty("defaultFloat")
    public Float getDefaultFloat (){
        return this.defaultFloat;
    }

 	private Double requiredAndDefaultDouble = 1000.11d;

    @JsonProperty("requiredAndDefaultDouble")
    public Double getRequiredAndDefaultDouble (){
        return this.requiredAndDefaultDouble;
    }

    @Enumerated(EnumType.STRING)
 	private Department requiredAndDefaultEnum = Department.EMPLOYEE;

    @JsonProperty("requiredAndDefaultEnum")
    public Department getRequiredAndDefaultEnum (){
        return this.requiredAndDefaultEnum;
    }

    @Length(max = 36)
    private String generatedUuid = UUID.randomUUID().toString();
    public void setGeneratedUuid(UUID uuidValue) {
    }

    @JsonProperty("generatedUuid")
    public String getGeneratedUuid (){
            return this.generatedUuid;
        }

 	private Long requiredAndDefaultLong = 1000L;

    @JsonProperty("requiredAndDefaultLong")
    public Long getRequiredAndDefaultLong (){
        return this.requiredAndDefaultLong;
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

    @Column(columnDefinition = "DATETIME(6)")
 	private Date customDate;

    @JsonProperty("customDate")
    public Date getCustomDate (){
        return this.customDate;
    }

    @Length(max = 36)
    private String requiredAndGeneratedUuid = UUID.randomUUID().toString();
    public void setRequiredAndGeneratedUuid(UUID uuidValue) {
    }

    @JsonProperty("requiredAndGeneratedUuid")
    public String getRequiredAndGeneratedUuid (){
            return this.requiredAndGeneratedUuid;
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

    @Enumerated(EnumType.STRING)
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

    @NotNull(message = "requiredLong is required")
 	private Long requiredLong;

    @JsonProperty("requiredLong")
    public Long getRequiredLong (){
        return this.requiredLong;
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
    @Length(max = 36)
    private String requiredUuid;
    public void setRequiredUuid(UUID uuidValue) {
        this.requiredUuid = (uuidValue != null) ? uuidValue.toString() : null;
    }

    @JsonProperty("requiredUuid")
    public String getRequiredUuid (){
            return this.requiredUuid;
        }

    @Length(max = 10)
 	private String lengthString;

    @JsonProperty("lengthString")
    public String getLengthString (){
        return this.lengthString;
    }

    @Length(max = 255)
 	private String normalString;

    @JsonProperty("normalString")
    public String getNormalString (){
        return this.normalString;
    }

 	private Integer normalInteger = 0;

    @JsonProperty("normalInteger")
    public Integer getNormalInteger (){
        return this.normalInteger;
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

    @Length(max = 255)
 	private String requiredAndDefaultString = "Default String Value";

    @JsonProperty("requiredAndDefaultString")
    public String getRequiredAndDefaultString (){
        return this.requiredAndDefaultString;
    }

 	private Date createdAndUpdatedDate;

    @JsonProperty("createdAndUpdatedDate")
    public Date getCreatedAndUpdatedDate (){
        return this.createdAndUpdatedDate;
    }

    @NotNull(message = "requiredEnum is required")
    @Enumerated(EnumType.STRING)
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
    @Enumerated(EnumType.STRING)
 	private Department normalEnum;

    @JsonProperty("normalEnum")
    public Department getNormalEnum (){
        return this.normalEnum;
    }

 	private Boolean defaultBoolean = true;

    @JsonProperty("defaultBoolean")
    public Boolean getDefaultBoolean (){
        return this.defaultBoolean;
    }

    @Length(max = 36)
    private String normalUuid;
    public void setNormalUuid(UUID uuidValue) {
        this.normalUuid = (uuidValue != null) ? uuidValue.toString() : null;
    }

    @JsonProperty("normalUuid")
    public String getNormalUuid (){
            return this.normalUuid;
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

 	private Boolean normalBoolean = false;

    @JsonProperty("normalBoolean")
    public Boolean getNormalBoolean (){
        return this.normalBoolean;
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

    @Length(max = 255)
 	private String defaultString = "Default String Value";

    @JsonProperty("defaultString")
    public String getDefaultString (){
        return this.defaultString;
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

 	private Date requiredAndCreatedDate;

    @JsonProperty("requiredAndCreatedDate")
    public Date getRequiredAndCreatedDate (){
        return this.requiredAndCreatedDate;
    }

 	private Boolean requiredAndDefaultBoolean = true;

    @JsonProperty("requiredAndDefaultBoolean")
    public Boolean getRequiredAndDefaultBoolean (){
        return this.requiredAndDefaultBoolean;
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

