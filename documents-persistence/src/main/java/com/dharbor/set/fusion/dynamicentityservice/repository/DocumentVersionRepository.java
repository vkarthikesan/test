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
import com.dharbor.set.fusion.dynamicentityservice.model.DocumentVersion;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "DocumentVersion:")
@RepositoryRestResource
public interface DocumentVersionRepository extends JpaRepository<DocumentVersion, Long>{
    @ApiOperation(
        value = "findByVersionMetadataId"
    )
    @Transactional
    List<DocumentVersion> findByVersionMetadataIdAndDeleted(
             @Param("id") @RequestParam("id") Long id,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @RestResource(path="findByDocumentIdDmsIdAndVersionId")
    @ApiOperation(
        value = "query-documentDmsVersion", notes = "Query: SELECT dv FROM DocumentVersion dv WHERE dv.documentId = :documentId AND dv.dmsId = :dmsId AND dv.versionId = :versionId"
    )
    @Query(
        value = "SELECT dv FROM DocumentVersion dv WHERE dv.documentId = :documentId AND dv.dmsId = :dmsId AND dv.versionId = :versionId"
    )
    @Transactional
    DocumentVersion findOneByDocumentIdAndDmsIdAndVersionId(
             @Param("documentId") @RequestParam("documentId") Long documentId,
             @Param("dmsId") @RequestParam("dmsId") String dmsId,
             @Param("versionId") @RequestParam("versionId") String versionId
    );

    @RestResource(path="findByDocxIdCreatedDateAndDeleted")
    @ApiOperation(
        value = "findByDocumentIdAndCreatedDateLessThanOrderByCreatedDateDesc"
    )
    @Transactional
    Page<DocumentVersion> findByDocumentIdAndCreatedDateLessThanAndDeletedOrderByCreatedDateDesc(
             @Param("documentId") @RequestParam("documentId") Long documentId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @ApiOperation(
        value = "findByDocumentIdOrDmsIdOrVersionId"
    )
    @Transactional
    List<DocumentVersion> findByDocumentIdOrDmsIdOrVersionIdAndDeleted(
             @Param("documentId") @RequestParam("documentId") Long documentId,
             @Param("dmsId") @RequestParam("dmsId") String dmsId,
             @Param("versionId") @RequestParam("versionId") String versionId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @ApiOperation(
        value = "query-selectAll", notes = "Query: SELECT dv FROM DocumentVersion dv"
    )
    @Query(
        value = "SELECT dv FROM DocumentVersion dv"
    )
    @Transactional
    List<DocumentVersion> findAllDocumentVersion(
    );

    @ApiOperation(
        value = "query-deleteAllDB", notes = "Query: DELETE DocumentVersion dv WHERE dv.id = :id"
    )
    @Query(
        value = "DELETE DocumentVersion dv WHERE dv.id = :id"
    )
    @Modifying
    @Transactional
    Integer deleteDocumentVersionById(
             @Param("id") @RequestParam("id") Long id
    );

    @Override
    @RestResource(exported = false)
    public void delete(DocumentVersion entity);
}