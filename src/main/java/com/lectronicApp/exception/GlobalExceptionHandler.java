package com.lectronicApp.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lectronicApp.exception.custom.NotFoundException;
import com.lectronicApp.model.dto.response.ResponseError;

@ControllerAdvice
public class GlobalExceptionHandler {
  private ResponseError<Object> responseError;
  private Map<String, Object> errors;

  @ExceptionHandler(value = RuntimeException.class)
  public ResponseEntity<?> handleRuntimeEx(RuntimeException e) {
    responseError = new ResponseError<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now(), e.getMessage());
    return ResponseEntity.status(responseError.getStatus()).body(responseError);
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleValidation(MethodArgumentNotValidException e) {
    errors = new HashMap<>();
    e.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
    responseError = new ResponseError<Object>(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), "Error validation!",
        errors);
    return ResponseEntity.status(responseError.getStatus()).body(responseError);
  }

  @ExceptionHandler(value = NotFoundException.class)
  public ResponseEntity<?> handleNotFoundEx(NotFoundException ex) {
    responseError = new ResponseError<>(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), ex.getMessage());
    return ResponseEntity.status(responseError.getStatus()).body(responseError);
  }
}
