
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

public @Data class Address implements BaseEntity {


    @Length(max = 255)
 	private String area;

 	private Integer streetNo = 0;

    @Length(max = 255)
 	private String city;

 	private Integer pinCode = 0;

 	private Integer doorNo = 0;


}