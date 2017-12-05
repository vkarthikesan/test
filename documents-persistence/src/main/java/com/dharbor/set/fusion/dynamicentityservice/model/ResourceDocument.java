package com.dharbor.set.fusion.dynamicentityservice.model;

import java.io.Serializable;
import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import java.util.Date;
import java.util.UUID;
import java.util.Set;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

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

