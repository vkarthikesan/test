package com.dharbor.set.fusion.dynamicentityservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by vkarthikesan on 3/1/2017.
 *
 * Transfer object for exception response
 */
@Data
@AllArgsConstructor
public class FusionExceptionResponse {

    private int status;
    private String reason;
}
