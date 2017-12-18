package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.AllDataTypes;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "AllDataTypes:")
@RepositoryRestResource
public interface AllDataTypesRepository extends JpaRepository<AllDataTypes, Long>{
    @Transactional
    AllDataTypes findById(
             @Param("id") @RequestParam("id") Long id
    );

    @Transactional
    AllDataTypes findByCreatedDateBetween(
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("from_createdDate") @RequestParam("from_createdDate") Date from_createdDate,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("to_createdDate") @RequestParam("to_createdDate") Date to_createdDate
    );

    @Transactional
    AllDataTypes findByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString
    );

    @Transactional
    AllDataTypes findByNormalStringIgnoreCase(
             @Param("normalString") @RequestParam("normalString") String normalString
    );

    @Transactional
    AllDataTypes findByLengthString(
             @Param("lengthString") @RequestParam("lengthString") String lengthString
    );

    @Transactional
    AllDataTypes findByLargeString(
             @Param("largeString") @RequestParam("largeString") String largeString
    );

    @Transactional
    AllDataTypes findByNormalInteger(
             @Param("normalInteger") @RequestParam("normalInteger") Integer normalInteger
    );

    @Transactional
    AllDataTypes findByNormalLong(
             @Param("normalLong") @RequestParam("normalLong") Long normalLong
    );

    @Transactional
    AllDataTypes findByNormalFloat(
             @Param("normalFloat") @RequestParam("normalFloat") Float normalFloat
    );

    @Transactional
    AllDataTypes findByNormalDouble(
             @Param("normalDouble") @RequestParam("normalDouble") Double normalDouble
    );

    @Transactional
    AllDataTypes findByNormalEnum(
             @Param("normalEnum") @RequestParam("normalEnum") Department normalEnum
    );

    @Transactional
    AllDataTypes findByNormalBoolean(
             @Param("normalBoolean") @RequestParam("normalBoolean") Boolean normalBoolean
    );

    @Transactional
    AllDataTypes findByNormalUuid(
             @Param("normalUuid") @RequestParam("normalUuid") String normalUuid
    );

    @Transactional
    AllDataTypes findByNormalDate(
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("normalDate") @RequestParam("normalDate") Date normalDate
    );

    @Transactional
    AllDataTypes findByMaxLengthForIndexString(
             @Param("maxLengthForIndexString") @RequestParam("maxLengthForIndexString") String maxLengthForIndexString
    );

    @Transactional
    AllDataTypes findByMinLengthForNoIndexString(
             @Param("minLengthForNoIndexString") @RequestParam("minLengthForNoIndexString") String minLengthForNoIndexString
    );

    @Transactional
    Set<AllDataTypes> findFirst10ByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString
    );

    @Transactional
    List<AllDataTypes> queryFirst10ByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @Transactional
    List<AllDataTypes> findTop3ByNormalStringOrderByNormalStringDesc(
             @Param("normalString") @RequestParam("normalString") String normalString,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @Transactional
    List<AllDataTypes> findByEmbbededAttributeStringAttr(
             @Param("stringAttr") @RequestParam("stringAttr") String stringAttr,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @Transactional
    AllDataTypes findByDefaultIntegerAndDefaultLong(
             @Param("defaultInteger") @RequestParam("defaultInteger") Integer defaultInteger,
             @Param("defaultLong") @RequestParam("defaultLong") Long defaultLong
    );

    @Transactional
    Long countByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString
    );

}