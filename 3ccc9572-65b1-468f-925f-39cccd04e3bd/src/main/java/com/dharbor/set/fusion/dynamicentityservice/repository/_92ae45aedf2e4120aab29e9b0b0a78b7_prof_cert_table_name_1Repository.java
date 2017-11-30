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

Copyright © 2002-2017, Digital Harbor, Inc. All rights reserved. No part of this publication, including its interior design and\
icons, may be reproduced, stored in a retrieval system, or transmitted in any form by any means, electronic, mechanical,
photocopying, recording, or otherwise, without written permission of Digital Harbor.*/

package com.dharbor.set.fusion.dynamicentityservice.repository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.dharbor.set.fusion.dynamicentityservice.model._92ae45aedf2e4120aab29e9b0b0a78b7_prof_cert_table_name_1;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Api(tags = "_92ae45aedf2e4120aab29e9b0b0a78b7_prof_cert_table_name_1:")
@RepositoryRestResource(path="92ae45ae-df2e-4120-aab2-9e9b0b0a78b7_prof_cert_table_name_1")
public interface _92ae45aedf2e4120aab29e9b0b0a78b7_prof_cert_table_name_1Repository extends JpaRepository<_92ae45aedf2e4120aab29e9b0b0a78b7_prof_cert_table_name_1, String>{
    @RestResource(path="findByApplication_resource_id")
    @Transactional
    List<_92ae45aedf2e4120aab29e9b0b0a78b7_prof_cert_table_name_1> findByApplicationResourceId(
             @Param("application_resource_id") @RequestParam("application_resource_id") String application_resource_id,
             @Param("pageable") @RequestParam("pageable") Pageable pageable
    );

}