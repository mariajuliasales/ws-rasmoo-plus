package com.mariajulia.client.ws.rasmooplus.exception.handler;

import com.mariajulia.client.ws.rasmooplus.dto.error.ErrorResponse;
import com.mariajulia.client.ws.rasmooplus.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(NotFoundException n) {
        String errorMessage = n.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder()
                .message(n.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> messages = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(messages.toString())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
