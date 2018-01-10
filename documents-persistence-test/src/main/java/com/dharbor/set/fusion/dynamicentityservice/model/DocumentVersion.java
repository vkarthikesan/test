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
                name = "findByDocumentIdAndDmsIdAndVersionId",
                columnList = "dmsId,versionId,documentId,deleted"
            ),
            @Index(
                name = "findTop1ByDocumentIdAndDmsId",
                columnList = "dmsId,documentId,deleted"
            ),
            @Index(
                name = "findByDocumentIdAndCreatedDateLessThanOrderByCreatedDateDesc",
                columnList = "documentId,createdDate,deleted"
            ),
            @Index(
                name = "findByVersionMetadataId",
                columnList = "deleted"
            )
        }
)
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class DocumentVersion implements BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "dmsId is required")
    @Length(max = 255)
 	private String dmsId;

    @NotBlank(message = "versionId is required")
    @Length(max = 255)
 	private String versionId;

    @NotNull(message = "isDefault is required")
 	private Boolean isDefault;

 	private Boolean deleted = false;

 	private Date createdDate;

 	private Date deletedDate;

    @OneToOne(
            optional = false,
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER
    )
    @JoinColumn(unique = true)
    @RestResource(exported = false)
 	private VersionMetadata versionMetadata;

    @NotNull(message = "documentId is required")
 	private Long documentId;

    public void onBeforeCreate() {
        Date sysDate = new Date();
        createdDate=sysDate;
    }

}

