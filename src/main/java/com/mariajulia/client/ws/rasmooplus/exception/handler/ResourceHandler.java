package com.mariajulia.client.ws.rasmooplus.exception.handler;

import com.mariajulia.client.ws.rasmooplus.dto.error.ErrorResponse;
import com.mariajulia.client.ws.rasmooplus.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

}
