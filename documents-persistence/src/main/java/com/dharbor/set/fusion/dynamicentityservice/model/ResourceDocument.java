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

package com.dharbor.set.fusion.dynamicentityservice.model;

import java.io.Serializable;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import java.util.Date;
import java.util.UUID;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;
import org.springframework.data.rest.core.annotation.RestResource;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(
        indexes = {
            @Index(
                name = "findByResourceIdAndCreatedDateLessThanAndDeletedOrderByCreatedDateDesc",
                columnList = "resourceId,createdDate,deleted"
            ),
            @Index(
                name = "findByDocumentUserIdAndDocumentDeletedAndDocumentCreatedDateLessThanOrderByCreatedDateDesc",
                columnList = "createdDate"
            ),
            @Index(
                name = "findByResourceId",
                columnList = "resourceId"
            )
        }
)
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class ResourceDocument implements BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "resourceId is required")
    @Length(max = 255)
 	private String resourceId;

    @NotBlank(message = "appResourceId is required")
    @Length(max = 255)
 	private String appResourceId;

 	private Boolean deleted = false;

 	private Date createdDate;

 	private Date deletedDate;

 	private Boolean formLibrary = false;

    @ManyToOne(
            optional = true,
            fetch = FetchType.EAGER
    )
    @RestResource(exported = false)
 	private Document document;

    @NotNull(message = "documentVersionId is required")
 	private Long documentVersionId;

    @NotBlank(message = "resourceUUID is required")
    @Length(max = 255)
 	private String resourceUUID;

    public void onBeforeCreate() {
        Date sysDate = new Date();
        createdDate=sysDate;
    }

}

