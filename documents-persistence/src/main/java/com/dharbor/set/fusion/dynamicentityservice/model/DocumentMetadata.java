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
                name = "findByNameAndTitleContaining",
                columnList = "name,title"
            ),
            @Index(
                name = "findByUserIdAndCreatedDateLessThanAndDocumentMetadataTitleContainingAndDeletedOrderByCreatedDateDesc",
                columnList = "title"
            )
        }
)
@Entity
public @Data class DocumentMetadata implements BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(max = 255)
 	private String name;

    @Length(max = 500)
 	private String description = "TEXT";

    @Length(max = 255)
 	private String title;

}

