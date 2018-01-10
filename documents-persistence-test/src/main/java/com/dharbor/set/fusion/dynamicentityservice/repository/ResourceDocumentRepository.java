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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.ResourceDocument;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "ResourceDocument:")
@RepositoryRestResource
public interface ResourceDocumentRepository extends JpaRepository<ResourceDocument, Long>{
    @ApiOperation(
        value = "findByResourceId"
    )
    @Transactional
    List<ResourceDocument> findByResourceIdAndDeleted(
             @Param("resourceId") @RequestParam("resourceId") String resourceId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @ApiOperation(
        value = "findTop1ByDocumentId"
    )
    @Transactional
    ResourceDocument findTop1ByDocumentIdAndDeleted(
             @Param("id") @RequestParam("id") Long id,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @RestResource(path="findByUserIdAndDeleted")
    @ApiOperation(
        value = "findByDocumentUserIdOrderByCreatedDateDesc"
    )
    @Transactional
    Page<ResourceDocument> findByDocumentUserIdAndDeletedOrderByCreatedDateDesc(
             @Param("userId") @RequestParam("userId") String userId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByResourceIdAndBeforeDateAndDeleted")
    @ApiOperation(
        value = "findByResourceIdAndCreatedDateLessThanOrderByCreatedDateDesc"
    )
    @Transactional
    Page<ResourceDocument> findByResourceIdAndCreatedDateLessThanAndDeletedOrderByCreatedDateDesc(
             @Param("resourceId") @RequestParam("resourceId") String resourceId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByUserIdAndBeforeDateAndDeleted")
    @ApiOperation(
        value = "findByDocumentUserIdAndDocumentCreatedDateLessThanOrderByCreatedDateDesc"
    )
    @Transactional
    Page<ResourceDocument> findByDocumentUserIdAndDocumentCreatedDateLessThanAndDeletedOrderByCreatedDateDesc(
             @Param("userId") @RequestParam("userId") String userId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @Override
    @RestResource(exported = false)
    public void delete(ResourceDocument entity);
}