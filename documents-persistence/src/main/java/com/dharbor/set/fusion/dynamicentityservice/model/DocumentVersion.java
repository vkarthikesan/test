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
                name = "findByDocumentIdAndDmsIdAndVersionId",
                columnList = "dmsId,versionId,documentId"
            ),
            @Index(
                name = "findByDocumentIdAndCreatedDateLessThanAndDeletedOrderByCreatedDateDesc",
                columnList = "documentId,createdDate,deleted"
            ),
            @Index(
                name = "findTop1ByDocumentIdAndDmsIdAndDeleted",
                columnList = "dmsId,documentId,deleted"
            )
        }
)
@Entity
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

