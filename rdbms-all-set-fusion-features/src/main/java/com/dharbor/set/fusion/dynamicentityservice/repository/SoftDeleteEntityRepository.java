package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.SoftDeleteEntity;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "SoftDeleteEntity:")
@RepositoryRestResource
public interface SoftDeleteEntityRepository extends JpaRepository<SoftDeleteEntity, Long>{
    @Transactional
    Long deleteBySoftDeleteIdAndDeleted(
             @Param("softDeleteId") @RequestParam("softDeleteId") Integer softDeleteId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @Transactional
    SoftDeleteEntity findBySoftDeleteIdAndDeleted(
             @Param("softDeleteId") @RequestParam("softDeleteId") Integer softDeleteId,
             @Param("deleted") @RequestParam("deleted") Boolean deleted
    );

    @Override
    @RestResource(exported = false)
    public void delete(SoftDeleteEntity entity);
}