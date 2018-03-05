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
public @Setter class NullValuesEntity implements BaseEntity {

    NullValuesEntity () {}

    @Id
    private String id;

    @JsonProperty("id")
    public String getId(){
        return this.id;
    }

 	private List<String> collectionString;

 	@JsonProperty("collectionString")
    public List<String> getCollectionString (){
        return this.collectionString;
     }

 	private Map<String, Department> mapString;

 	@JsonProperty("mapString")
    public Map<String, Department> getMapString (){
        return this.mapString;
     }

 	private Long normalLong = 0L;

 	@JsonProperty("normalLong")
    public Long getNormalLong (){
        return this.normalLong;
     }

 	private UUID normalUuid;

 	@JsonProperty("normalUuid")
    public UUID getNormalUuid (){
        return this.normalUuid;
     }

 	private Date customDate;

 	@JsonProperty("customDate")
    public Date getCustomDate (){
        return this.customDate;
     }

 	private Boolean normalBoolean = false;

 	@JsonProperty("normalBoolean")
    public Boolean getNormalBoolean (){
        return this.normalBoolean;
     }

 	private List<EmbeddedProperties> collectionEmbeddedEntity;

 	@JsonProperty("collectionEmbeddedEntity")
    public List<EmbeddedProperties> getCollectionEmbeddedEntity (){
        return this.collectionEmbeddedEntity;
     }

 	private Date normalDate;

 	@JsonProperty("normalDate")
    public Date getNormalDate (){
        return this.normalDate;
     }

 	private List<Address> collectionEntity;

 	@JsonProperty("collectionEntity")
    public List<Address> getCollectionEntity (){
        return this.collectionEntity;
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

 	private Float normalFloat = 0.0f;

 	@JsonProperty("normalFloat")
    public Float getNormalFloat (){
        return this.normalFloat;
     }



}