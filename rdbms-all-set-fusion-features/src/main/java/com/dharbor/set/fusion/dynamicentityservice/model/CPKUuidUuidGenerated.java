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
public @Data class CPKUuidUuidGenerated implements BaseEntity {


    @EmbeddedId
    private CompositeKey primaryKey;

    @Data
    @Embeddable
    public static class CompositeKey implements Serializable {
        @NotNull(message = "Primary key primaryKey2 is mandatory")
        private String primaryKey2;
        public void setPrimaryKey2(UUID uuidValue) {
            this.primaryKey2 = (uuidValue != null) ? uuidValue.toString() : null;
        }
        @NotNull(message = "Primary key primaryKey1 is mandatory")
        private String primaryKey1;
        public void setPrimaryKey1(UUID uuidValue) {
            this.primaryKey1 = (uuidValue != null) ? uuidValue.toString() : null;
        }
    }

}

