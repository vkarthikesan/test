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
import com.dharbor.set.fusion.dynamicentityservice.model.Message;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "Message:")
@RepositoryRestResource
public interface MessageRepository extends MongoRepository<Message, String>{
    @RestResource(path="findByConversationIdCreatedDateLt")
    @ApiOperation(
        value = "query-conversationDateLt", notes = "Query: {'conversationId':'?0', 'createdDate': {'$lt': ?1, 'sort': -1}}"
    )
    @Query(
        value = "{'conversationId':'?0', 'createdDate': {'$lt': ?1, 'sort': -1}}"
    )
    Page<Message> findByConversationIdAndCreatedDateLessThanOrderByCreatedDateDesc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByConversationIdCreatedDateGt")
    @ApiOperation(
        value = "query-conversationDateGt", notes = "Query: {'conversationId':'?0', 'createdDate': {'$gt': ?1}}"
    )
    @Query(
        value = "{'conversationId':'?0', 'createdDate': {'$gt': ?1}}"
    )
    Page<Message> findByConversationIdAndCreatedDateGreaterThanOrderByCreatedDateAsc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByConversationIdSeeMsgTypeAndCreatedDateDesc")
    @ApiOperation(
        value = "findByConversationIdAndSeenAndMessageTypeAndCreatedDateLessThanOrderByCreatedDateDesc", notes = "Query: {'conversationId':'?0', 'seen': '?1', 'messageType': '?2', 'createdDate': {'$lt': ?3}}"
    )
    @Query(
        value = "{'conversationId':'?0', 'seen': '?1', 'messageType': '?2', 'createdDate': {'$lt': ?3}}"
    )
    Page<Message> findByConversationIdAndSeenAndMessageTypeAndCreatedDateLessThanOrderByCreatedDateDesc(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("seen") @RequestParam("seen") Boolean seen,
             @Param("messageType") @RequestParam("messageType") MessageType messageType,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByConversationIdSeenAndMsgType")
    @ApiOperation(
        value = "findOneByConversationIdAndMessageTypeAndSeen"
    )
    Message findOneByConversationIdAndMessageTypeAndSeenAndDeleted(
             @Param("conversationId") @RequestParam("conversationId") String conversationId,
             @Param("messageType") @RequestParam("messageType") MessageType messageType,
             @Param("seen") @RequestParam("seen") Boolean seen,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @ApiOperation(
        value = "query-selectAll", notes = "Query: {}"
    )
    @Query(
        value = "{}"
    )
    List<Message> findAllMessages(
    );

    @Override
    @RestResource(exported = false)
    public void delete(Message entity);
}