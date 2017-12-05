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
                name = "findByUserId",
                columnList = "userId"
            )
        }
)
@Entity
public @Data class UserSettings implements BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "rootFolderDmsId is required")
    @Length(max = 255)
 	private String rootFolderDmsId;

    @NotBlank(message = "rootFolder is required")
    @Length(max = 255)
 	private String rootFolder;

    @NotBlank(message = "userId is required")
    @Length(max = 255)
 	private String userId;

}

