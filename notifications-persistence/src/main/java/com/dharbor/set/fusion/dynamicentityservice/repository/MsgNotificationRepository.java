package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model.MsgNotification;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "MsgNotification:")
@RepositoryRestResource
public interface MsgNotificationRepository extends MongoRepository<MsgNotification, String>{
    List<MsgNotification> findByUserIdAndStateAndNotificationDateLessThanOrderByNotificationDateDesc(
             @Param("userId") @RequestParam("userId") String userId,
             @Param("state") @RequestParam("state") MsgNotificationState state,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("notificationDate") @RequestParam("notificationDate") Date notificationDate,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    List<MsgNotification> findByUserIdAndNotificationDateLessThan(
             @Param("userId") @RequestParam("userId") String userId,
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("notificationDate") @RequestParam("notificationDate") Date notificationDate,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    List<MsgNotification> findByUserIdOrderByNotificationDateDesc(
             @Param("userId") @RequestParam("userId") String userId,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    Long countByUserIdAndState(
             @Param("userId") @RequestParam("userId") String userId,
             @Param("state") @RequestParam("state") MsgNotificationState state
    );

    Long countByUserId(
             @Param("userId") @RequestParam("userId") String userId
    );

}