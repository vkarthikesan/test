/*DIGITAL HARBOR COPYRIGHT
sadfsdafdas
sdafdasfds*/

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
                name = "findByChildNormalEnum",
                columnList = "deleted"
            ),
            @Index(
                name = "existsByFirstName",
                columnList = "firstName,deleted"
            )
        }
)
@Entity
public @Data class ParentEntityWithSoftDelete implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(max = 255)
 	private String firstName;

 	private Boolean deleted = false;

    @OneToOne(
            optional = true,
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @JoinColumn(unique = true)
    @RestResource(exported = false)
 	private ChildEntityWithSoftDelete child;

}

