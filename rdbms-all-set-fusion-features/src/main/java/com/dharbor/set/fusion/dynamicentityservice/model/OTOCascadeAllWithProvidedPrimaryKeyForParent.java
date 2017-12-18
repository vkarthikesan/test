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

@Entity
public @Data class OTOCascadeAllWithProvidedPrimaryKeyForParent implements BaseEntity {


    @Id
    @NotNull(message = "Primary key primaryKey is mandatory")
    private Integer primaryKey;

    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(unique = true)
    @RestResource(exported = false)
 	private ProfilePicture picture;

}

