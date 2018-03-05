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
import com.dharbor.set.fusion.dynamicentityservice.model.AtQueryEntity;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "AtQueryEntity:")
@RepositoryRestResource
public interface AtQueryEntityRepository extends MongoRepository<AtQueryEntity, String>{
    @ApiOperation(
        value = "findAllEmployees", notes = "Query: {}"
    )
    @Query(
        value = "{}"
    )
    Page<AtQueryEntity> findAllEmployees(
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @ApiOperation(
        value = "findElderEmployeesByAge", notes = "Query: {'age':{'$gt':?0}}"
    )
    @Query(
        value = "{'age':{'$gt':?0}}"
    )
    Page<AtQueryEntity> findElderEmployeesByAge(
             @Param("age") @RequestParam("age") Integer age,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

    @ApiOperation(
        value = "countEmployeeByFirstName", notes = "Query: {'firstName':'?0'}"
    )
    @Query(
        value = "{'firstName':'?0'}", count = true
    )
    Long countEmployeeByFirstName(
             @Param("firstName") @RequestParam("firstName") String firstName
    );

    @ApiOperation(
        value = "deleteEmployeeByLastName", notes = "Query: {'lastName':'?0'}"
    )
    @Query(
        value = "{'lastName':'?0'}", delete = true
    )
    Integer deleteEmployeeByLastName(
             @Param("lastName") @RequestParam("lastName") String lastName
    );

    @ApiOperation(
        value = "employeeExist", notes = "Query: {'firstName':'?0','lastName':'?1','age':?2}"
    )
    @Query(
        value = "{'firstName':'?0','lastName':'?1','age':?2}", exists = true
    )
    Boolean employeeExist(
             @Param("firstName") @RequestParam("firstName") String firstName,
             @Param("lastName") @RequestParam("lastName") String lastName,
             @Param("age") @RequestParam("age") Integer age
    );

}