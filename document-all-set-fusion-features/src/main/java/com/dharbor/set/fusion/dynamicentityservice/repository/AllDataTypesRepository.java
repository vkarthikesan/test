package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.AllDataTypes;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "AllDataTypes:")
@RepositoryRestResource
public interface AllDataTypesRepository extends MongoRepository<AllDataTypes, String>{
    AllDataTypes findById(
             @Param("id") @RequestParam("id") String id
    );

    AllDataTypes findByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString
    );

    AllDataTypes findByLengthString(
             @Param("lengthString") @RequestParam("lengthString") String lengthString
    );

    AllDataTypes findByLargeString(
             @Param("largeString") @RequestParam("largeString") String largeString
    );

    AllDataTypes findByNormalInteger(
             @Param("normalInteger") @RequestParam("normalInteger") Integer normalInteger
    );

    AllDataTypes findByNormalLong(
             @Param("normalLong") @RequestParam("normalLong") Long normalLong
    );

    AllDataTypes findByNormalFloat(
             @Param("normalFloat") @RequestParam("normalFloat") Float normalFloat
    );

    AllDataTypes findByNormalDouble(
             @Param("normalDouble") @RequestParam("normalDouble") Double normalDouble
    );

    AllDataTypes findByNormalEnum(
             @Param("normalEnum") @RequestParam("normalEnum") Department normalEnum
    );

    AllDataTypes findByNormalBoolean(
             @Param("normalBoolean") @RequestParam("normalBoolean") Boolean normalBoolean
    );

    AllDataTypes findByNormalUuid(
             @Param("normalUuid") @RequestParam("normalUuid") UUID normalUuid
    );

    AllDataTypes findByNormalDate(
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("normalDate") @RequestParam("normalDate") Date normalDate
    );

    AllDataTypes findByMaxLengthForIndexString(
             @Param("maxLengthForIndexString") @RequestParam("maxLengthForIndexString") String maxLengthForIndexString
    );

    AllDataTypes findByMinLengthForNoIndexString(
             @Param("minLengthForNoIndexString") @RequestParam("minLengthForNoIndexString") String minLengthForNoIndexString
    );

    Set<AllDataTypes> findFirst10ByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString
    );

    List<AllDataTypes> queryFirst10ByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    List<AllDataTypes> findTop3ByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    AllDataTypes findByDefaultIntegerAndDefaultLong(
             @Param("defaultInteger") @RequestParam("defaultInteger") Integer defaultInteger,
             @Param("defaultLong") @RequestParam("defaultLong") Long defaultLong
    );

    Long countByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString
    );

}