package com.arslanesra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /*  @ExceptionHandler(Exception.class)
      public ResponseEntity<BaseResponse> handleException(Exception ex) {
          BaseResponse response = new BaseResponse();
          response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
          response.setMessage("An error occurred");
          response.setData(null);

          return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }*/
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}

