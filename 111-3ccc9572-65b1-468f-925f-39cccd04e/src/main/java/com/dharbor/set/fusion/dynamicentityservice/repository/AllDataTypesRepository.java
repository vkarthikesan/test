/*Digital Harbor International, Inc. makes no representations or warranties with respect to the contents or use of this manual,
and specifically disclaims any express or implied warranties of merchantability or fitness for any particular purpose. Digital
Harbor, Inc. reserves the right to revise this publication and to make changes to its content, at any time, without obligation to
notify any person or entity of such revisions or changes. Digital Harbor International, Inc. makes no representations or
warranties with respect to any Digital Harbor software, and specifically disclaims any express or implied warranties of
merchantability or fitness for any particular purpose. There are no warranties that extend beyond the descriptions contained in
these paragraphs. No warranty may be created or extended by sales representatives or written sales materials. Digital Harbor,
Inc. reserves the right to make changes to any and all parts of Digital Harbor software, at any time, without any obligation to
notify any person or entity of such changes. Digital Harbor, Inc. shall not be liable for any loss of profit or any other commercial
damages, including but not limited to special, incidental, consequential, or other damages.

Copyright © 2002-2018, Digital Harbor, Inc. All rights reserved. No part of this publication, including its interior design and\
icons, may be reproduced, stored in a retrieval system, or transmitted in any form by any means, electronic, mechanical,
photocopying, recording, or otherwise, without written permission of Digital Harbor.*/

package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.Query;
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

@Api(tags = "AllDataTypes:AllDataTypes Entity Description")
@RepositoryRestResource
public interface AllDataTypesRepository extends MongoRepository<AllDataTypes, String>{
    @ApiOperation(
        value = "findById", notes = "findById CustomQuery Description"
    )
    AllDataTypes findById(
             @Param("id") @RequestParam("id") String id
    );

    @ApiOperation(
        value = "findByNormalString"
    )
    AllDataTypes findByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString
    );

    @ApiOperation(
        value = "findByLengthString"
    )
    AllDataTypes findByLengthString(
             @Param("lengthString") @RequestParam("lengthString") String lengthString
    );

    @ApiOperation(
        value = "findByLargeString"
    )
    AllDataTypes findByLargeString(
             @Param("largeString") @RequestParam("largeString") String largeString
    );

    @ApiOperation(
        value = "findByNormalInteger"
    )
    AllDataTypes findByNormalInteger(
             @Param("normalInteger") @RequestParam("normalInteger") Integer normalInteger
    );

    @ApiOperation(
        value = "findByNormalLong"
    )
    AllDataTypes findByNormalLong(
             @Param("normalLong") @RequestParam("normalLong") Long normalLong
    );

    @ApiOperation(
        value = "findByNormalFloat"
    )
    AllDataTypes findByNormalFloat(
             @Param("normalFloat") @RequestParam("normalFloat") Float normalFloat
    );

    @ApiOperation(
        value = "findByNormalDouble"
    )
    AllDataTypes findByNormalDouble(
             @Param("normalDouble") @RequestParam("normalDouble") Double normalDouble
    );

    @ApiOperation(
        value = "findByNormalEnum"
    )
    AllDataTypes findByNormalEnum(
             @Param("normalEnum") @RequestParam("normalEnum") Department normalEnum
    );

    @ApiOperation(
        value = "findByNormalBoolean"
    )
    AllDataTypes findByNormalBoolean(
             @Param("normalBoolean") @RequestParam("normalBoolean") Boolean normalBoolean
    );

    @ApiOperation(
        value = "findByNormalUuid"
    )
    AllDataTypes findByNormalUuid(
             @Param("normalUuid") @RequestParam("normalUuid") UUID normalUuid
    );

    @ApiOperation(
        value = "findByNormalDate"
    )
    AllDataTypes findByNormalDate(
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("normalDate") @RequestParam("normalDate") Date normalDate
    );

    @ApiOperation(
        value = "findByMaxLengthForIndexString"
    )
    AllDataTypes findByMaxLengthForIndexString(
             @Param("maxLengthForIndexString") @RequestParam("maxLengthForIndexString") String maxLengthForIndexString
    );

    @ApiOperation(
        value = "findByMinLengthForNoIndexString"
    )
    AllDataTypes findByMinLengthForNoIndexString(
             @Param("minLengthForNoIndexString") @RequestParam("minLengthForNoIndexString") String minLengthForNoIndexString
    );

    @ApiOperation(
        value = "findFirst10ByNormalString"
    )
    List<AllDataTypes> findFirst10ByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString
    );

    @ApiOperation(
        value = "queryFirst10ByNormalString"
    )
    Page<AllDataTypes> queryFirst10ByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @ApiOperation(
        value = "findTop3ByNormalString"
    )
    Page<AllDataTypes> findTop3ByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @ApiOperation(
        value = "findByDefaultIntegerAndDefaultLong"
    )
    AllDataTypes findByDefaultIntegerAndDefaultLong(
             @Param("defaultInteger") @RequestParam("defaultInteger") Integer defaultInteger,
             @Param("defaultLong") @RequestParam("defaultLong") Long defaultLong
    );

    @ApiOperation(
        value = "countByNormalString"
    )
    Long countByNormalString(
             @Param("normalString") @RequestParam("normalString") String normalString
    );

}