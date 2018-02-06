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
    @ApiOperation(
        value = "findByConversationId"
    )
    List<Participant> findByConversationId(
             @Param("conversationId") @RequestParam("conversationId") String conversationId
    );

    @ApiOperation(
        value = "findByConversationIdAndParticipantType"
    )
    List<Participant> findByConversationIdAndParticipantType(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("participantType") @RequestParam("participantType") ParticipantType participantType
    );

    @ApiOperation(
        value = "findByConversationIdAndUserId"
    )
    List<Participant> findByConversationIdAndUserId(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("userId") @RequestParam("userId") String userId
    );

    @ApiOperation(
        value = "findByConversationIdAndUserIdAndParticipantType"
    )
    List<Participant> findByConversationIdAndUserIdAndParticipantType(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("userId") @RequestParam("userId") String userId,
             @Param("participantType") @RequestParam("participantType") ParticipantType participantType
    );

    @ApiOperation(
        value = "findByConversationIdOrderByJoinedOnAsc"
    )
    Page<Participant> findByConversationIdOrderByJoinedOnAsc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByConversationRemoveJoinedOn")
    @ApiOperation(
        value = "findByConversationIdAndRemovedAndJoinedOnGreaterThanOrderByJoinedOnAsc"
    )
    Page<Participant> findByConversationIdAndRemovedAndJoinedOnGreaterThanOrderByJoinedOnAsc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("removed") @RequestParam("removed") Boolean removed,
             @Param("joinedOn") @RequestParam("joinedOn") Long joinedOn,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByIdConversationRemoveJoinedOn")
    @ApiOperation(
        value = "findByIdNotAndConversationIdAndRemovedAndJoinedOnGreaterThanOrderByJoinedOnAsc"
    )
    Page<Participant> findByIdNotAndConversationIdAndRemovedAndJoinedOnGreaterThanOrderByJoinedOnAsc(
             @Param("id") @RequestParam("id") String id,
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("removed") @RequestParam("removed") Boolean removed,
             @Param("joinedOn") @RequestParam("joinedOn") Long joinedOn,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByIdConversationRemove")
    @ApiOperation(
        value = "findByIdNotAndConversationIdAndRemovedOrderByJoinedOnAsc"
    )
    Page<Participant> findByIdNotAndConversationIdAndRemovedOrderByJoinedOnAsc(
             @Param("id") @RequestParam("id") String id,
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("removed") @RequestParam("removed") Boolean removed,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @ApiOperation(
        value = "findByIdAndConversationId"
    )
    List<Participant> findByIdAndConversationId(
             @Param("id") @RequestParam("id") String id,
             @Param("conversationId") @RequestParam("conversationId") String conversationId
    );

}