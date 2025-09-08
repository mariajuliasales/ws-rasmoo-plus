package com.mariajulia.client.ws.rasmooplus.dto.error;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ErrorResponse(String message,
                            HttpStatus httpStatus,
                            Integer statusCode) {

}