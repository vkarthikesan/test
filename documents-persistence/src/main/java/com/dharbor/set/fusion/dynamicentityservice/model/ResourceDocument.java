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
import lombok.Setter;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;
import org.springframework.data.rest.core.annotation.RestResource;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(
        indexes = {
            @Index(
                name = "findByDocumentUserIdAndDocumentCreatedDateLessThanAndDeletedOrderByCreatedDateDesc",
                columnList = "deleted,createdDate"
            ),
            @Index(
                name = "findByResourceIdAndCreatedDateLessThanAndDeletedOrderByCreatedDateDesc",
                columnList = "resourceId,createdDate,deleted"
            ),
            @Index(
                name = "findByResourceId",
                columnList = "resourceId"
            )
        }
)
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public @Setter class ResourceDocument implements BaseEntity {

    ResourceDocument () {}


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("id")
    public Long getId(){
        return this.id;
    }

    @NotBlank(message = "resourceId is required")
    @Length(max = 255)
 	private String resourceId;

    @JsonProperty("resourceId")
    public String getResourceId (){
        return this.resourceId;
    }

    @NotBlank(message = "appResourceId is required")
    @Length(max = 255)
 	private String appResourceId;

    @JsonProperty("appResourceId")
    public String getAppResourceId (){
        return this.appResourceId;
    }

 	private Boolean deleted = false;

    @JsonProperty("deleted")
    public Boolean getDeleted (){
        return this.deleted;
    }

 	private Date createdDate;

    @JsonProperty("createdDate")
    public Date getCreatedDate (){
        return this.createdDate;
    }

 	private Date deletedDate;

    @JsonProperty("deletedDate")
    public Date getDeletedDate (){
        return this.deletedDate;
    }

 	private Boolean formLibrary = false;

    @JsonProperty("formLibrary")
    public Boolean getFormLibrary (){
        return this.formLibrary;
    }

    @ManyToOne(
            optional = true,
            cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    @RestResource(exported = false)
 	private Document document;

    @JsonProperty("document")
    public Document getDocument (){
        return this.document;
    }

    @NotNull(message = "documentVersionId is required")
 	private Long documentVersionId;

    @JsonProperty("documentVersionId")
    public Long getDocumentVersionId (){
        return this.documentVersionId;
    }

    @NotBlank(message = "resourceUUID is required")
    @Length(max = 255)
 	private String resourceUUID;

    @JsonProperty("resourceUUID")
    public String getResourceUUID (){
        return this.resourceUUID;
    }

    public void onBeforeCreate() {
        Date sysDate = new Date();
        createdDate=sysDate;
    }

}

