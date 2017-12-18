package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.CPKUuidLong;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "CPKUuidLong:")
@RepositoryRestResource
public interface CPKUuidLongRepository extends JpaRepository<CPKUuidLong, CPKUuidLong.CompositeKey>{
    @RestResource(path="get")
    @Transactional
    CPKUuidLong findByPrimaryKey_PrimaryKey1(
             @Param("primaryKey1") @RequestParam("primaryKey1") String primaryKey1
    );

    @ApiOperation(
        value = "Retrieve record by unique key", notes = "Auto generated custom query to get record using composite primary key"
    )
    @Transactional
    CPKUuidLong findByPrimaryKey_PrimaryKey1AndPrimaryKey_PrimaryKey2(
             @Param("primaryKey1") @RequestParam("primaryKey1") String primaryKey1,
             @Param("primaryKey2") @RequestParam("primaryKey2") Long primaryKey2
    );

    @ApiOperation(
        value = "Delete record by unique key", notes = "Auto generated custom query to delete record using composite primary key"
    )
    @Transactional
    Long deleteByPrimaryKey_PrimaryKey1AndPrimaryKey_PrimaryKey2(
             @Param("primaryKey1") @RequestParam("primaryKey1") String primaryKey1,
             @Param("primaryKey2") @RequestParam("primaryKey2") Long primaryKey2
    );

}