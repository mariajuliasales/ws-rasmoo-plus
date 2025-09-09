package com.mariajulia.client.ws.rasmooplus.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserTypeRequest(
        @NotBlank(message = "O campo nome não pode ser nulo ou vazio")
        String name,

        @NotBlank(message = "O campo descrição não pode ser nulo ou vazio")
        String description
) {
}
