
package com.dharbor.set.fusion.dynamicentityservice.model;

import com.dharbor.set.fusion.dynamicentityservice.enums.*;
import java.util.Date;
import java.util.UUID;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.Valid;
import lombok.Data;

@KeySpace
public @Data class AllDataTypes implements BaseEntity {

    @Id
    @NotBlank(message = "Primary key normalString is mandatory")
    private String normalString;

 	private Float defaultFloat = 100.11f;

 	private Double requiredAndDefaultDouble = 1000.11d;

 	private Department requiredAndDefaultEnum = Department.EMPLOYEE;

    @ReadOnlyProperty
    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")
    private String generatedUuid = UUID.randomUUID().toString();

 	private Long requiredAndDefaultLong = 1000L;

    @NotNull(message = "requiredDate is required")
 	private Date requiredDate;

 	private Date updatedDate;

    @ReadOnlyProperty
    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")
    private String requiredAndGeneratedUuid = UUID.randomUUID().toString();

    @NotNull(message = "requiredBoolean is required")
 	private Boolean requiredBoolean;

 	private Department defaultEnum = Department.EMPLOYEE;

 	private Integer requiredAndDefaultInteger = 100;

    @NotNull(message = "requiredLong is required")
 	private Long requiredLong;

 	private Integer defaultInteger = 100;

 	private Date normalDate;

    @NotNull(message = "requiredUuid is required")
    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")
    private String requiredUuid;

    @Length(max = 10)
 	private String lengthString;

 	private Integer normalInteger = 0;

    @Length(max = 10000)
 	private String largeString;

 	private Double defaultDouble = 1000.11d;

    @Length(max = 255)
 	private String requiredAndDefaultString = "Default String Value";

    @ReadOnlyProperty
 	private Date createdAndUpdatedDate;

    @NotNull(message = "requiredEnum is required")
 	private Department requiredEnum;

 	private Long normalLong = 0L;

    @NotNull(message = "normalEnum is required")
 	private Department normalEnum;

 	private Boolean defaultBoolean = true;

    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")
    private String normalUuid;

    @NotNull(message = "requiredFloat is required")
 	private Float requiredFloat;

 	private Long defaultLong = 1000L;

    @NotBlank(message = "requiredString is required")
    @Length(max = 255)
 	private String requiredString;

 	private Date requiredAndUpdatedDate;

    @NotNull(message = "requiredDouble is required")
 	private Double requiredDouble;

 	private Boolean normalBoolean = false;

 	private Float requiredAndDefaultFloat = 100.11f;

    @ReadOnlyProperty
 	private Date createdDate;

    @Length(max = 255)
 	private String defaultString = "Default String Value";

 	private Double normalDouble = 0.0d;

    @NotNull(message = "requiredInteger is required")
 	private Integer requiredInteger;

 	private Float normalFloat = 0.0f;

    @ReadOnlyProperty
 	private Date requiredAndCreatedDate;

 	private Boolean requiredAndDefaultBoolean = true;


    public void onBeforeCreate() {
        Date sysDate = new Date();
        createdAndUpdatedDate=sysDate;
        createdDate=sysDate;
        requiredAndCreatedDate=sysDate;
        updatedDate=sysDate;
        createdAndUpdatedDate=sysDate;
        requiredAndUpdatedDate=sysDate;
    }

    public void onBeforeSave() {
        Date sysDate = new Date();
        updatedDate=sysDate;
        createdAndUpdatedDate=sysDate;
        requiredAndUpdatedDate=sysDate;
    }
}