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
import com.dharbor.set.fusion.dynamicentityservice.model.TextContent;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "TextContent:")
@RepositoryRestResource
public interface TextContentRepository extends MongoRepository<TextContent, String>{
    @ApiOperation(
        value = "consulta-para-Uno", notes = "Query: {'messageId': '?0'}"
    )
    @Query(
        value = "{'messageId': '?0'}"
    )
    TextContent findOneMessageId(
             @Param("messageId") @RequestParam("messageId") String messageId
    );

    @ApiOperation(
        value = "consulta-para-todos-mayores-que", notes = "Query: {'valorDecimal': {'$gt': ?0}}"
    )
    @Query(
        value = "{'valorDecimal': {'$gt': ?0}}"
    )
    Page<TextContent> findByValorDecimal(
             @Param("valorDecimal") @RequestParam("valorDecimal") Double valorDecimal,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @ApiOperation(
        value = "consulta-Existente", notes = "Query: {'messageId': '?0'}"
    )
    @Query(
        value = "{'messageId': '?0'}", exists = true
    )
    Boolean TextContentExist(
             @Param("messageId") @RequestParam("messageId") String messageId
    );

    @RestResource(path="MessageValorGt")
    @ApiOperation(
        value = "findByMessageIdAndValorDecimalGreaterThanOrderByValorDecimalAsc"
    )
    Page<TextContent> findByMessageIdAndValorDecimalGreaterThanAndDeletedOrderByValorDecimalAsc(
             @Param("messageId") @RequestParam("messageId") String messageId,
             @Param("valorDecimal") @RequestParam("valorDecimal") Double valorDecimal,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @ApiOperation(
        value = "consulta-sort-manual", notes = "Query: {'messageId': '?0', 'valorDecimal': {'$gt': ?1}}"
    )
    @Query(
        value = "{'messageId': '?0', 'valorDecimal': {'$gt': ?1}}"
    )
    Page<TextContent> findByMessageIdAndValorDecimal(
             @Param("messageId") @RequestParam("messageId") String messageId,
             @Param("valorDecimal") @RequestParam("valorDecimal") Double valorDecimal,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @ApiOperation(
        value = "consulta-sort-manual", notes = "Query: {'messageId':'?0'}"
    )
    @Query(
        value = "{'messageId':'?0'}", count = true
    )
    Long countTextContentByMessageId(
             @Param("messageId") @RequestParam("messageId") String messageId
    );

    @ApiOperation(
        value = "countByMessageId"
    )
    Long countByMessageIdAndDeleted(
             @Param("messageId") @RequestParam("messageId") String messageId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @ApiOperation(
        value = "consulta-LikeContaining", notes = "Query: {'messageId': {'$regex': '?0'}}"
    )
    @Query(
        value = "{'messageId': {'$regex': '?0'}}", exists = true
    )
    Boolean TextContentTwoExist(
             @Param("messageId") @RequestParam("messageId") String messageId
    );

    @ApiOperation(
        value = "consulta-EliminarAllDB", notes = "Query: {'messageId': ?0}"
    )
    @Query(
        value = "{'messageId': ?0}", delete = true
    )
    Integer deleteTextContentByMessageId(
             @Param("messageId") @RequestParam("messageId") String messageId
    );

    @Override
    @RestResource(exported = false)
    public void delete(TextContent entity);
}