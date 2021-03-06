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

@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public @Setter class Employee implements BaseEntity {

    Employee () {}

    @Id
    private String id;

    @JsonProperty("id")
    public String getId(){
        return this.id;
    }

    @Length(max = 255)
 	private String lastName;

 	@JsonProperty("lastName")
    public String getLastName (){
        return this.lastName;
     }

 	private Float defaultFloat = 100f;

 	@JsonProperty("defaultFloat")
    public Float getDefaultFloat (){
        return this.defaultFloat;
     }

 	private UUID generatedUuid = UUID.randomUUID();
 	public void setGeneratedUuid(UUID uuidValue) {}

 	@JsonProperty("generatedUuid")
    public UUID getGeneratedUuid (){
        return this.generatedUuid;
     }

 	private UUID employeeId;

 	@JsonProperty("employeeId")
    public UUID getEmployeeId (){
        return this.employeeId;
     }

 	private Date updatedDate;

 	@JsonProperty("updatedDate")
    public Date getUpdatedDate (){
        return this.updatedDate;
     }

 	private Long defaultLong = 1000L;

 	@JsonProperty("defaultLong")
    public Long getDefaultLong (){
        return this.defaultLong;
     }

 	private Long salary = 0L;

 	@JsonProperty("salary")
    public Long getSalary (){
        return this.salary;
     }

    @DBRef
    @RestResource(exported = false)
 	private ProfilePicture picture;

 	@JsonProperty("picture")
    public ProfilePicture getPicture (){
        return this.picture;
     }

    @NotBlank(message = "firstName is required")
    @Length(max = 255)
 	private String firstName;

 	@JsonProperty("firstName")
    public String getFirstName (){
        return this.firstName;
     }

 	private Date createdDate;

 	@JsonProperty("createdDate")
    public Date getCreatedDate (){
        return this.createdDate;
     }

 	private Integer phoneNumber = 0;

 	@JsonProperty("phoneNumber")
    public Integer getPhoneNumber (){
        return this.phoneNumber;
     }

 	private Float immovableAssets = 0.0f;

 	@JsonProperty("immovableAssets")
    public Float getImmovableAssets (){
        return this.immovableAssets;
     }

    @NotNull(message = "requiredUuid is required")
 	private UUID requiredUuid;

 	@JsonProperty("requiredUuid")
    public UUID getRequiredUuid (){
        return this.requiredUuid;
     }

 	private Double netWorth = 0.0d;

 	@JsonProperty("netWorth")
    public Double getNetWorth (){
        return this.netWorth;
     }

    @Length(max = 255)
 	private String defaultString = "1000";

 	@JsonProperty("defaultString")
    public String getDefaultString (){
        return this.defaultString;
     }

    @Length(max = 10)
 	private String lengthString;

 	@JsonProperty("lengthString")
    public String getLengthString (){
        return this.lengthString;
     }

    @NotNull(message = "department is required")
 	private Department department;

 	@JsonProperty("department")
    public Department getDepartment (){
        return this.department;
     }

    @Length(max = 10000)
 	private String largeString;

 	@JsonProperty("largeString")
    public String getLargeString (){
        return this.largeString;
     }

 	private Integer defaultInt = 100;

 	@JsonProperty("defaultInt")
    public Integer getDefaultInt (){
        return this.defaultInt;
     }

 	private Double defaultDouble = 1000d;

 	@JsonProperty("defaultDouble")
    public Double getDefaultDouble (){
        return this.defaultDouble;
     }


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