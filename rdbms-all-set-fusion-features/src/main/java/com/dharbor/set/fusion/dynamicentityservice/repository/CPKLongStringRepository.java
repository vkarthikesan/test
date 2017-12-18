package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.CPKLongString;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "CPKLongString:")
@RepositoryRestResource
public interface CPKLongStringRepository extends JpaRepository<CPKLongString, CPKLongString.CompositeKey>{
    @ApiOperation(
        value = "Retrieve record by unique key", notes = "Auto generated custom query to get record using composite primary key"
    )
    @Transactional
    CPKLongString findByPrimaryKey_PrimaryKey1AndPrimaryKey_PrimaryKey2(
             @Param("primaryKey1") @RequestParam("primaryKey1") Long primaryKey1,
             @Param("primaryKey2") @RequestParam("primaryKey2") String primaryKey2
    );

    @ApiOperation(
        value = "Delete record by unique key", notes = "Auto generated custom query to delete record using composite primary key"
    )
    @Transactional
    Long deleteByPrimaryKey_PrimaryKey1AndPrimaryKey_PrimaryKey2(
             @Param("primaryKey1") @RequestParam("primaryKey1") Long primaryKey1,
             @Param("primaryKey2") @RequestParam("primaryKey2") String primaryKey2
    );

}