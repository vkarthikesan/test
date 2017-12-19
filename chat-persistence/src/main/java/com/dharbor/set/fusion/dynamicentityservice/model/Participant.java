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

Copyright © 2002-2017, Digital Harbor, Inc. All rights reserved. No part of this publication, including its interior design and\
icons, may be reproduced, stored in a retrieval system, or transmitted in any form by any means, electronic, mechanical,
photocopying, recording, or otherwise, without written permission of Digital Harbor.*/

package com.dharbor.set.fusion.dynamicentityservice.model;

import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Data;
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

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@CompoundIndexes(
        value = {
            @CompoundIndex(
                name = "findByConversationIdAndParticipantType",
                def = "{'participantType':1 ,'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByConversationIdAndUserId",
                def = "{'userId':1 ,'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByIdNotAndConversationIdAndRemovedOrderByJoinedOnAsc",
                def = "{'joinedOn':1 ,'id':1 ,'removed':1 ,'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByIdAndConversationId",
                def = "{'conversationId':1 ,'id':1 }"
            ),
            @CompoundIndex(
                name = "findByConversationId",
                def = "{'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByConversationIdAndRemovedAndJoinedOnGreaterThanOrderByJoinedOnAsc",
                def = "{'joinedOn':1 ,'removed':1 ,'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByConversationIdOrderByJoinedOnAsc",
                def = "{'joinedOn':1 ,'conversationId':1 }"
            ),
            @CompoundIndex(
                name = "findByConversationIdAndUserIdAndParticipantType",
                def = "{'participantType':1 ,'userId':1 ,'conversationId':1 }"
            )
        }
)
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class Participant implements BaseEntity {

    @Id
    private String id;

 	private Long joinedOn = 0L;

 	private Date createdDate;

 	private Boolean removed = false;

    @NotBlank(message = "conversationId is required")
    @Length(max = 255)
 	private String conversationId;

 	private Date lastUpdateDate;

 	private ParticipantType participantType = ParticipantType.DEFAULT;

    @NotBlank(message = "userId is required")
    @Length(max = 255)
 	private String userId;


    public void onBeforeCreate() {
        Date sysDate = new Date();
        createdDate=sysDate;
        lastUpdateDate=sysDate;
    }

    public void onBeforeSave() {
        Date sysDate = new Date();
        lastUpdateDate=sysDate;
    }

}