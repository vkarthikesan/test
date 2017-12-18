package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.ParentEntityWithSoftDelete;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "ParentEntityWithSoftDelete:")
@RepositoryRestResource
public interface ParentEntityWithSoftDeleteRepository extends JpaRepository<ParentEntityWithSoftDelete, Long>{
    @Transactional
    ParentEntityWithSoftDelete findByChildDmsIdAndDeleted(
             @Param("dmsId") @RequestParam("dmsId") String dmsId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @Transactional
    Boolean existsByFirstNameAndDeleted(
             @Param("firstName") @RequestParam("firstName") String firstName,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @Transactional
    ParentEntityWithSoftDelete findByChildDeletedAndDeleted(
             @Param("deleted") @RequestParam("deleted") Boolean deleted,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @Transactional
    ParentEntityWithSoftDelete findByChildNormalEnumAndDeleted(
             @Param("normalEnum") @RequestParam("normalEnum") Department normalEnum,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @Override
    @RestResource(exported = false)
    public void delete(ParentEntityWithSoftDelete entity);
}