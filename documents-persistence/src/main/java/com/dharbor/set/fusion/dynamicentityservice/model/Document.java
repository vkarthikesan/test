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
                name = "findByDocumentUserIdAndDocumentDeletedAndDocumentCreatedDateLessThanOrderByCreatedDateDesc",
                columnList = "deleted,createdDate,userId"
            ),
            @Index(
                name = "findByUserIdAndDocumentCreatedDateLessThanAndDocumentIsVisibleOrderByDocumentCreatedDateDesc",
                columnList = "createdDate,isVisible"
            ),
            @Index(
                name = "findByUserIdAndCreatedDateLessThanAndIsVisibleOrderByCreatedDateDesc",
                columnList = "createdDate,isVisible,userId"
            ),
            @Index(
                name = "findByDmsId",
                columnList = "dmsId"
            ),
            @Index(
                name = "findByUserId",
                columnList = "userId"
            ),
            @Index(
                name = "findByDocumentUserIdAndDocumentDeletedOrderByCreatedDateDesc",
                columnList = "userId,deleted"
            )
        }
)
@Entity
public @Data class Document implements BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "dmsId is required")
    @Length(max = 255)
 	private String dmsId;

    @OneToOne(
            optional = false,
            fetch = FetchType.EAGER
    )
    @JoinColumn(unique = true)
    @RestResource(exported = false)
 	private DocumentMetadata documentMetadata;

 	private Boolean deleted = false;

 	private Date createdDate;

 	private Date deletedDate;

 	private Boolean isSensitive = false;

 	private Long currentVersionId = 0L;

    @NotBlank(message = "location is required")
    @Length(max = 255)
 	private String location;

 	private Boolean isVisible = false;

    @NotBlank(message = "userId is required")
    @Length(max = 255)
 	private String userId;

    public void onBeforeCreate() {
        Date sysDate = new Date();
        createdDate=sysDate;
    }

}

