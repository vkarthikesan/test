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

package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.Participant;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "Participant:")
@RepositoryRestResource
public interface ParticipantRepository extends MongoRepository<Participant, String>{
    @RestResource(path="AllConversationId")
    @ApiOperation(
        value = "findByConversationId"
    )
    List<Participant> findByConversationIdAndDeleted(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @RestResource(path="ConversationType")
    @ApiOperation(
        value = "findByConversationIdAndParticipantType"
    )
    List<Participant> findByConversationIdAndParticipantTypeAndDeleted(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("participantType") @RequestParam("participantType") ParticipantType participantType,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @RestResource(path="ConversationUser")
    @ApiOperation(
        value = "findByConversationIdAndUserId"
    )
    List<Participant> findByConversationIdAndUserIdAndDeleted(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("userId") @RequestParam("userId") String userId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @RestResource(path="ConversationUserType")
    @ApiOperation(
        value = "findByConversationIdAndUserIdAndParticipantType"
    )
    List<Participant> findByConversationIdAndUserIdAndParticipantTypeAndDeleted(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("userId") @RequestParam("userId") String userId,
             @Param("participantType") @RequestParam("participantType") ParticipantType participantType,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @RestResource(path="ConversationJoinedOn")
    @ApiOperation(
        value = "findByConversationIdOrderByJoinedOnAsc"
    )
    Page<Participant> findByConversationIdAndDeletedOrderByJoinedOnAsc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByConversatioDeletedJoinedOn")
    @ApiOperation(
        value = "findByConversationIdAndDeletedAndJoinedOnGreaterThanOrderByJoinedOnAsc"
    )
    Page<Participant> findByConversationIdAndDeletedAndJoinedOnGreaterThanAndDeletedOrderByJoinedOnAsc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("joinedOn") @RequestParam("joinedOn") Long joinedOn,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByIdConversatioDeletedJoinedOn")
    @ApiOperation(
        value = "findByIdNotAndConversationIdAndDeletedAndJoinedOnGreaterThanOrderByJoinedOnAsc"
    )
    Page<Participant> findByIdNotAndConversationIdAndDeletedAndJoinedOnGreaterThanAndDeletedOrderByJoinedOnAsc(
             @Param("id") @RequestParam("id") String id,
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("joinedOn") @RequestParam("joinedOn") Long joinedOn,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByIdConversatioDeleted")
    @ApiOperation(
        value = "findByIdNotAndConversationIdAndDeletedOrderByJoinedOnAsc"
    )
    Page<Participant> findByIdNotAndConversationIdAndDeletedAndDeletedOrderByJoinedOnAsc(
             @Param("id") @RequestParam("id") String id,
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="IdConversation")
    @ApiOperation(
        value = "findByIdAndConversationId"
    )
    List<Participant> findByIdAndConversationIdAndDeleted(
             @Param("id") @RequestParam("id") String id,
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @Override
    @RestResource(exported = false)
    public void delete(Participant entity);
}