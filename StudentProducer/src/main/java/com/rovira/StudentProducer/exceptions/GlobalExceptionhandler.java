package com.rovira.StudentProducer.exceptions;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rovira.StudentProducer.dto.ApiResponseDto;

@RestControllerAdvice 
public class GlobalExceptionhandler {

    @ExceptionHandler (InvalidInputException.class)
    public ResponseEntity<ApiResponseDto> handelInvalidInputException(InvalidInputException ex)
    {
        return new ResponseEntity<>(new ApiResponseDto(
                                   ex.getMessage(),
                                   HttpStatus.BAD_REQUEST.name(),
                                   HttpStatus.BAD_REQUEST.value()),
                                   HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (MandatoryFieldNotSpecifiedException.class)
    public ResponseEntity<ApiResponseDto> handelMandatoryFieldNotSpecifiedException(MandatoryFieldNotSpecifiedException ex)
    {
        return new ResponseEntity<>(new ApiResponseDto(
                                    ex.getMessage(),
                                    HttpStatus.BAD_REQUEST.name(),
                                    HttpStatus.BAD_REQUEST.value()),
                                    HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (RecordNotFoundException.class)
    public ResponseEntity<ApiResponseDto> handelRecordNotFoundException(RecordNotFoundException ex)
    {
        return new ResponseEntity<>(new ApiResponseDto(
                                    ex.getMessage(),
                                    HttpStatus.NOT_FOUND.name(),
                                    HttpStatus.NOT_FOUND.value()),
                                    HttpStatus.NOT_FOUND);
    }

}
