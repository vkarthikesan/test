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
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.Valid;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonProperty;

@KeySpace
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public @Setter class AllDataTypes implements BaseEntity {

    AllDataTypes () {}

    @Id
    @NotBlank(message = "Primary key normalString is mandatory")
    private String normalString;

    @JsonProperty("normalString")
    public String getNormalString(){
        return this.normalString;
    }

 	private Float defaultFloat = 100.11f;

 	 @JsonProperty("defaultFloat")
        private Float getDefaultFloat (){
            return this.defaultFloat;
        }

 	private Double requiredAndDefaultDouble = 1000.11d;

 	 @JsonProperty("requiredAndDefaultDouble")
        private Double getRequiredAndDefaultDouble (){
            return this.requiredAndDefaultDouble;
        }

 	private Department requiredAndDefaultEnum = Department.EMPLOYEE;

 	 @JsonProperty("requiredAndDefaultEnum")
        private Department getRequiredAndDefaultEnum (){
            return this.requiredAndDefaultEnum;
        }

    @ReadOnlyProperty
    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")
    private String generatedUuid = UUID.randomUUID().toString();

 	 @JsonProperty("generatedUuid")
        public String getGeneratedUuid (){
            return this.generatedUuid;
        }

 	private Long requiredAndDefaultLong = 1000L;

 	 @JsonProperty("requiredAndDefaultLong")
        private Long getRequiredAndDefaultLong (){
            return this.requiredAndDefaultLong;
        }

    @NotNull(message = "requiredDate is required")
 	private Date requiredDate;

 	 @JsonProperty("requiredDate")
        private Date getRequiredDate (){
            return this.requiredDate;
        }

 	private Date updatedDate;

 	 @JsonProperty("updatedDate")
        private Date getUpdatedDate (){
            return this.updatedDate;
        }

    @ReadOnlyProperty
    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")
    private String requiredAndGeneratedUuid = UUID.randomUUID().toString();

 	 @JsonProperty("requiredAndGeneratedUuid")
        public String getRequiredAndGeneratedUuid (){
            return this.requiredAndGeneratedUuid;
        }

    @NotNull(message = "requiredBoolean is required")
 	private Boolean requiredBoolean;

 	 @JsonProperty("requiredBoolean")
        private Boolean getRequiredBoolean (){
            return this.requiredBoolean;
        }

 	private Department defaultEnum = Department.EMPLOYEE;

 	 @JsonProperty("defaultEnum")
        private Department getDefaultEnum (){
            return this.defaultEnum;
        }

 	private Integer requiredAndDefaultInteger = 100;

 	 @JsonProperty("requiredAndDefaultInteger")
        private Integer getRequiredAndDefaultInteger (){
            return this.requiredAndDefaultInteger;
        }

    @NotNull(message = "requiredLong is required")
 	private Long requiredLong;

 	 @JsonProperty("requiredLong")
        private Long getRequiredLong (){
            return this.requiredLong;
        }

 	private Integer defaultInteger = 100;

 	 @JsonProperty("defaultInteger")
        private Integer getDefaultInteger (){
            return this.defaultInteger;
        }

 	private Date normalDate;

 	 @JsonProperty("normalDate")
        private Date getNormalDate (){
            return this.normalDate;
        }

    @NotNull(message = "requiredUuid is required")
    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")
    private String requiredUuid;

 	 @JsonProperty("requiredUuid")
        public String getRequiredUuid (){
            return this.requiredUuid;
        }

    @Length(max = 10)
 	private String lengthString;

 	 @JsonProperty("lengthString")
        private String getLengthString (){
            return this.lengthString;
        }

 	private Integer normalInteger = 0;

 	 @JsonProperty("normalInteger")
        private Integer getNormalInteger (){
            return this.normalInteger;
        }

    @Length(max = 10000)
 	private String largeString;

 	 @JsonProperty("largeString")
        private String getLargeString (){
            return this.largeString;
        }

 	private Double defaultDouble = 1000.11d;

 	 @JsonProperty("defaultDouble")
        private Double getDefaultDouble (){
            return this.defaultDouble;
        }

    @Length(max = 255)
 	private String requiredAndDefaultString = "Default String Value";

 	 @JsonProperty("requiredAndDefaultString")
        private String getRequiredAndDefaultString (){
            return this.requiredAndDefaultString;
        }

    @ReadOnlyProperty
 	private Date createdAndUpdatedDate;

 	 @JsonProperty("createdAndUpdatedDate")
        private Date getCreatedAndUpdatedDate (){
            return this.createdAndUpdatedDate;
        }

    @NotNull(message = "requiredEnum is required")
 	private Department requiredEnum;

 	 @JsonProperty("requiredEnum")
        private Department getRequiredEnum (){
            return this.requiredEnum;
        }

 	private Long normalLong = 0L;

 	 @JsonProperty("normalLong")
        private Long getNormalLong (){
            return this.normalLong;
        }

    @NotNull(message = "normalEnum is required")
 	private Department normalEnum;

 	 @JsonProperty("normalEnum")
        private Department getNormalEnum (){
            return this.normalEnum;
        }

 	private Boolean defaultBoolean = true;

 	 @JsonProperty("defaultBoolean")
        private Boolean getDefaultBoolean (){
            return this.defaultBoolean;
        }

    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")
    private String normalUuid;

 	 @JsonProperty("normalUuid")
        public String getNormalUuid (){
            return this.normalUuid;
        }

    @NotNull(message = "requiredFloat is required")
 	private Float requiredFloat;

 	 @JsonProperty("requiredFloat")
        private Float getRequiredFloat (){
            return this.requiredFloat;
        }

 	private Long defaultLong = 1000L;

 	 @JsonProperty("defaultLong")
        private Long getDefaultLong (){
            return this.defaultLong;
        }

    @NotBlank(message = "requiredString is required")
    @Length(max = 255)
 	private String requiredString;

 	 @JsonProperty("requiredString")
        private String getRequiredString (){
            return this.requiredString;
        }

 	private Date requiredAndUpdatedDate;

 	 @JsonProperty("requiredAndUpdatedDate")
        private Date getRequiredAndUpdatedDate (){
            return this.requiredAndUpdatedDate;
        }

    @NotNull(message = "requiredDouble is required")
 	private Double requiredDouble;

 	 @JsonProperty("requiredDouble")
        private Double getRequiredDouble (){
            return this.requiredDouble;
        }

 	private Boolean normalBoolean = false;

 	 @JsonProperty("normalBoolean")
        private Boolean getNormalBoolean (){
            return this.normalBoolean;
        }

 	private Float requiredAndDefaultFloat = 100.11f;

 	 @JsonProperty("requiredAndDefaultFloat")
        private Float getRequiredAndDefaultFloat (){
            return this.requiredAndDefaultFloat;
        }

    @ReadOnlyProperty
 	private Date createdDate;

 	 @JsonProperty("createdDate")
        private Date getCreatedDate (){
            return this.createdDate;
        }

    @Length(max = 255)
 	private String defaultString = "Default String Value";

 	 @JsonProperty("defaultString")
        private String getDefaultString (){
            return this.defaultString;
        }

 	private Double normalDouble = 0.0d;

 	 @JsonProperty("normalDouble")
        private Double getNormalDouble (){
            return this.normalDouble;
        }

    @NotNull(message = "requiredInteger is required")
 	private Integer requiredInteger;

 	 @JsonProperty("requiredInteger")
        private Integer getRequiredInteger (){
            return this.requiredInteger;
        }

 	private Float normalFloat = 0.0f;

 	 @JsonProperty("normalFloat")
        private Float getNormalFloat (){
            return this.normalFloat;
        }

    @ReadOnlyProperty
 	private Date requiredAndCreatedDate;

 	 @JsonProperty("requiredAndCreatedDate")
        private Date getRequiredAndCreatedDate (){
            return this.requiredAndCreatedDate;
        }

 	private Boolean requiredAndDefaultBoolean = true;

 	 @JsonProperty("requiredAndDefaultBoolean")
        private Boolean getRequiredAndDefaultBoolean (){
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