package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.DocumentGroup;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "DocumentGroup:")
@RepositoryRestResource
public interface DocumentGroupRepository extends JpaRepository<DocumentGroup, Long>{
    @RestResource(path="findGroupByUserId")
    List<DocumentGroup> findByUserIdAndDocumentCreatedDateLessThanAndDocumentIsVisibleOrderByDocumentCreatedDateDesc(
             @Param("userId") @RequestParam("userId") String userId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("isVisible") @RequestParam("isVisible") Boolean isVisible,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @RestResource(path="findGroupByUserIdPage")
    List<DocumentGroup> findByUserIdAndDocumentIsVisibleOrderByDocumentCreatedDateDesc(
             @Param("userId") @RequestParam("userId") String userId,
             @Param("isVisible") @RequestParam("isVisible") Boolean isVisible,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

}