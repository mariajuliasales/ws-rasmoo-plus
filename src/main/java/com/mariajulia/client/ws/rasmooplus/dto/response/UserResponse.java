package com.mariajulia.client.ws.rasmooplus.dto.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserResponse(
        Long id,
        String name,
        String email,
        String phone,
        String cpf,
        LocalDate dtSubscription,
        LocalDate dtExpiration,
        String userType,
        String subscriptionType) {
}
