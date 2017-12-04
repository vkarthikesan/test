package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.Message;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "Message:")
@RepositoryRestResource
public interface MessageRepository extends JpaRepository<Message, Long>{
    List<Message> findByExplanationId(
             @Param("id") @RequestParam("id") Long id,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    List<Message> findByExplanationIdAndCreatedDateOrderByCreatedDateDesc(
             @Param("id") @RequestParam("id") Long id,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    List<Message> findByExplanationIdAndCreatedDateLessThanAndDeletedOrderByCreatedDateDesc(
             @Param("id") @RequestParam("id") Long id,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("createdDate") @RequestParam("createdDate") Date createdDate,
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

}