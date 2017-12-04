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
                name = "findByExplanationIdAndCreatedDateLessThanAndDeletedOrderByCreatedDateDesc",
                columnList = "createdDate,deleted"
            ),
            @Index(
                name = "findByExplanationIdAndCreatedDateOrderByCreatedDateDesc",
                columnList = "createdDate"
            )
        }
)
@Entity
public @Data class Message implements BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

 	private Date createdDate;

 	private Boolean deleted = false;

 	private Boolean edited = false;

 	private Date updatedDate;

    @ManyToOne(
            optional = true,
            fetch = FetchType.EAGER
    )
    @RestResource(exported = false)
 	private Explanation explanation;

    @NotBlank(message = "userId is required")
    @Length(max = 255)
 	private String userId;

    @NotNull(message = "contentType is required")
    @Enumerated(EnumType.STRING)
 	private ContentType contentType;

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

