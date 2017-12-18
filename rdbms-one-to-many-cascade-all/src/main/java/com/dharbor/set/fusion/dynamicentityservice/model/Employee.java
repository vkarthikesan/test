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
public @Data class Employee implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

 	private Float defaultFloat = 100f;

    @Length(max = 255)
 	private String lastName;

    @Length(max = 36)
    private String employeeId;
    public void setEmployeeId(UUID uuidValue) {
        this.employeeId = (uuidValue != null) ? uuidValue.toString() : null;
    }

 	private Date updatedDate;

 	private Long defaultLong = 1000L;

 	private Long salary = 0L;

    @OneToMany(
            cascade = {CascadeType.ALL}
    )
    @RestResource(exported = false)
 	private Set<ProfilePicture> picture;

    @NotBlank(message = "firstName is required")
    @Length(max = 255)
 	private String firstName;

 	private Date createdDate;

 	private Integer phoneNumber = 0;

 	private Float immovableAssets = 0.0f;

    @NotNull(message = "requiredUuid is required")
    @Length(max = 36)
    private String requiredUuid;
    public void setRequiredUuid(UUID uuidValue) {
        this.requiredUuid = (uuidValue != null) ? uuidValue.toString() : null;
    }

 	private Double netWorth = 0.0d;

    @Length(max = 255)
 	private String defaultString = "1000";

    @Length(max = 10)
 	private String lengthString;

    @NotNull(message = "department is required")
    @Enumerated(EnumType.STRING)
 	private Department department;

    @Length(max = 10000)
 	private String largeString;

 	private Integer defaultInt = 100;

 	private Double defaultDouble = 1000d;

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

