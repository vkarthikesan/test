package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.ResourceDocument;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "ResourceDocument:")
@RepositoryRestResource
public interface ResourceDocumentRepository extends JpaRepository<ResourceDocument, Long>{
    @RestResource(path="findByResourceIdAndBeforeDateAndDeleted")
    List<ResourceDocument> findByResourceIdAndCreatedDateLessThanAndDeletedOrderByCreatedDateDesc(
             @Param("resourceId") @RequestParam("resourceId") String resourceId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    ResourceDocument findTop1ByDocumentId(
             @Param("id") @RequestParam("id") Long id
    );

    @RestResource(path="findByResourceIdAndDeleted")
    List<ResourceDocument> findByResourceIdAndDeletedOrderByCreatedDateDesc(
             @Param("resourceId") @RequestParam("resourceId") String resourceId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByUserIdAndBeforeDateAndDeleted")
    List<ResourceDocument> findByDocumentUserIdAndDocumentDeletedAndDocumentCreatedDateLessThanOrderByCreatedDateDesc(
             @Param("userId") @RequestParam("userId") String userId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findByUserIdAndDeleted")
    List<ResourceDocument> findByDocumentUserIdAndDocumentDeletedOrderByCreatedDateDesc(
             @Param("userId") @RequestParam("userId") String userId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    Collection<ResourceDocument> findByResourceId(
             @Param("resourceId") @RequestParam("resourceId") String resourceId
    );

}