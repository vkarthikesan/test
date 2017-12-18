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