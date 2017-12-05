package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.DocumentVersion;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "DocumentVersion:")
@RepositoryRestResource
public interface DocumentVersionRepository extends JpaRepository<DocumentVersion, Long>{
    Collection<DocumentVersion> findByVersionMetadataId(
             @Param("id") @RequestParam("id") Long id
    );

    DocumentVersion findTop1ByDocumentIdAndDmsIdAndDeleted(
             @Param("documentId") @RequestParam("documentId") Long documentId,
             @Param("dmsId") @RequestParam("dmsId") String dmsId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @RestResource(path="findByDocxIdAndDateAndDeleted")
    List<DocumentVersion> findByDocumentIdAndCreatedDateLessThanAndDeletedOrderByCreatedDateDesc(
             @Param("documentId") @RequestParam("documentId") Long documentId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    DocumentVersion findByDocumentIdAndDmsIdAndVersionId(
             @Param("documentId") @RequestParam("documentId") Long documentId,
             @Param("dmsId") @RequestParam("dmsId") String dmsId,
             @Param("versionId") @RequestParam("versionId") String versionId
    );

    Collection<DocumentVersion> findByDocumentIdOrDmsIdOrVersionId(
             @Param("documentId") @RequestParam("documentId") Long documentId,
             @Param("dmsId") @RequestParam("dmsId") String dmsId,
             @Param("versionId") @RequestParam("versionId") String versionId
    );

}