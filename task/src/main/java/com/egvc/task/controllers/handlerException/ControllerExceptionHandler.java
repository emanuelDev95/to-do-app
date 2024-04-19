package com.egvc.task.controllers.handlerException;

import com.egvc.msproducts.dtos.ErrorMessageResponse;
import com.egvc.task.exceptions.ResourceNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessageResponse resourceNotFoundException(ResourceNotFoundException ex) {
    return  new ErrorMessageResponse(
        HttpStatus.NOT_FOUND.value(),
        new Date(),
        ex.getMessage());
    
  }


  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessageResponse> globalExceptionHandler(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ErrorMessageResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    new Date(),
                    ex.getMessage()));
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorMessageResponse> constraintViolationExceptionHandler(ConstraintViolationException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ErrorMessageResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    new Date(),
                    ex.getMessage()
            ));
  }
}