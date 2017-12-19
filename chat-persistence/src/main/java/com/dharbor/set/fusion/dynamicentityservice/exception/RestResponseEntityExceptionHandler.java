/*Digital Harbor International, Inc. makes no representations or warranties with respect to the contents or use of this manual,
and specifically disclaims any express or implied warranties of merchantability or fitness for any particular purpose. Digital
Harbor, Inc. reserves the right to revise this publication and to make changes to its content, at any time, without obligation to
notify any person or entity of such revisions or changes. Digital Harbor International, Inc. makes no representations or
warranties with respect to any Digital Harbor software, and specifically disclaims any express or implied warranties of
merchantability or fitness for any particular purpose. There are no warranties that extend beyond the descriptions contained in
these paragraphs. No warranty may be created or extended by sales representatives or written sales materials. Digital Harbor,
Inc. reserves the right to make changes to any and all parts of Digital Harbor software, at any time, without any obligation to
notify any person or entity of such changes. Digital Harbor, Inc. shall not be liable for any loss of profit or any other commercial
damages, including but not limited to special, incidental, consequential, or other damages.

Copyright © 2002-2017, Digital Harbor, Inc. All rights reserved. No part of this publication, including its interior design and\
icons, may be reproduced, stored in a retrieval system, or transmitted in any form by any means, electronic, mechanical,
photocopying, recording, or otherwise, without written permission of Digital Harbor.*/

package com.dharbor.set.fusion.dynamicentityservice.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.UncategorizedDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * Created by vkarthikesan on 3/1/2017.
 */
@ControllerAdvice
class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {TransactionSystemException.class})
    protected ResponseEntity<Object> handleConflict(TransactionSystemException ex, WebRequest request) {
        Throwable originalException = ex.getRootCause();

        if(originalException != null && originalException instanceof  ConstraintViolationException) {
            return handleConflict((ConstraintViolationException) originalException, request);
        }

        return handleExceptionInternal(ex,
                new FusionExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<Object> handleConflict(ConstraintViolationException ex, WebRequest request) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

        String embeddedMessage = " is required";
        StringBuilder message = new StringBuilder();
        for(ConstraintViolation v : violations) {
            message.append((v.getPropertyPath() != null
                    && !v.getMessage().startsWith(String.valueOf(v.getPropertyPath())))
                    ? v.getPropertyPath() + embeddedMessage + " " : (v.getMessage()) + " ").append("; ");
        }

        return handleExceptionInternal(ex,
                new FusionExceptionResponse(HttpStatus.CONFLICT.value(), message.toString()),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {DataAccessException.class})
    protected ResponseEntity<Object> handleDataAccessException(DataAccessException ex, WebRequest request) {

        String message = ex.getMessage();

        Throwable th = ex.getRootCause();
        if(th != null && th.getMessage() != null)
            message = th.getMessage();

        return handleExceptionInternal(ex,
                new FusionExceptionResponse(HttpStatus.CONFLICT.value(), message),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {DataAccessResourceFailureException.class, UncategorizedDataAccessException.class})
    protected ResponseEntity<Object> handleConflict(DataAccessException ex, WebRequest request) {
        return handleExceptionInternal(ex,
                new FusionExceptionResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), ex.getMessage()),
                new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE, request);
    }
}