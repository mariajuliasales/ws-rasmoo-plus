package com.mariajulia.client.ws.rasmooplus.dto.response;

import lombok.Builder;

@Builder
public record UserTypeResponse(
        Long id,
        String name,
        String description
) {
}
