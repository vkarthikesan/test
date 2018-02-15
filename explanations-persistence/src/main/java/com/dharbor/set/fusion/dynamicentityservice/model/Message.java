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
                name = "findByExplanationId",
                columnList = "deleted"
            ),
            @Index(
                name = "findByExplanationIdAndCreatedDateLessThanOrderByCreatedDateDesc",
                columnList = "createdDate,deleted"
            )
        }
)
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public @Setter class Message implements BaseEntity {

    Message () {}


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("id")
    public Long getId(){
        return this.id;
    }

 	private Date createdDate;

    @JsonProperty("createdDate")
    public Date getCreatedDate (){
        return this.createdDate;
    }

 	private Boolean deleted = false;

    @JsonProperty("deleted")
    public Boolean getDeleted (){
        return this.deleted;
    }

 	private Boolean edited = false;

    @JsonProperty("edited")
    public Boolean getEdited (){
        return this.edited;
    }

 	private Date updatedDate;

    @JsonProperty("updatedDate")
    public Date getUpdatedDate (){
        return this.updatedDate;
    }

    @ManyToOne(
            optional = true,
            cascade = {CascadeType.MERGE,CascadeType.REMOVE},
            fetch = FetchType.EAGER
    )
    @RestResource(exported = false)
 	private Explanation explanation;

    @JsonProperty("explanation")
    public Explanation getExplanation (){
        return this.explanation;
    }

    @NotBlank(message = "userId is required")
    @Length(max = 255)
 	private String userId;

    @JsonProperty("userId")
    public String getUserId (){
        return this.userId;
    }

    @NotNull(message = "contentType is required")
    @Enumerated(EnumType.STRING)
 	private ContentType contentType;

    @JsonProperty("contentType")
    public ContentType getContentType (){
        return this.contentType;
    }

    public void onBeforeCreate() {
        Date sysDate = new Date();
        createdDate=sysDate;
        updatedDate=sysDate;
    }

    public void onBeforeSave() {
        Date sysDate = new Date();
        updatedDate=sysDate;
    }

}

