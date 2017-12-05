package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.EmailNotification;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "EmailNotification:")
@RepositoryRestResource
public interface EmailNotificationRepository extends MongoRepository<EmailNotification, String>{
    List<EmailNotification> findByUserIdAndSubjectAndNotificationDateLessThanOrderByNotificationDateDesc(
             @Param("userId") @RequestParam("userId") String userId,
             @Param("subject") @RequestParam("subject") String subject,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("notificationDate") @RequestParam("notificationDate") Date notificationDate,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    List<EmailNotification> findByResourceId(
             @Param("resourceId") @RequestParam("resourceId") String resourceId,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    Long countByUserId(
             @Param("userId") @RequestParam("userId") String userId
    );

}