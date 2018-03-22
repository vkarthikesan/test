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
                name = "findOneByUserIdAndResourceId",
                def = "{'userId':1 ,'resourceId':1 }"
            )
        }
)
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public @Setter class ResourceConversationRegistry implements BaseEntity {

    ResourceConversationRegistry () {}

    @Id
    private String id;

    @JsonProperty("id")
    public String getId(){
        return this.id;
    }

    @NotBlank(message = "appResourceId is required")
    @Length(max = 255)
 	private String appResourceId;

 	@JsonProperty("appResourceId")
    public String getAppResourceId (){
        return this.appResourceId;
     }

    @NotBlank(message = "resourceId is required")
    @Length(max = 255)
 	private String resourceId;

 	@JsonProperty("resourceId")
    public String getResourceId (){
        return this.resourceId;
     }

    @NotBlank(message = "conversationId is required")
    @Length(max = 255)
 	private String conversationId;

 	@JsonProperty("conversationId")
    public String getConversationId (){
        return this.conversationId;
     }

    @NotBlank(message = "userId is required")
    @Length(max = 255)
 	private String userId;

 	@JsonProperty("userId")
    public String getUserId (){
        return this.userId;
     }

    @NotBlank(message = "resourceUUID is required")
    @Length(max = 255)
 	private String resourceUUID;

 	@JsonProperty("resourceUUID")
    public String getResourceUUID (){
        return this.resourceUUID;
     }



}