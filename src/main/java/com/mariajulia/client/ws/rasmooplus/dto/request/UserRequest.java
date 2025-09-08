package com.mariajulia.client.ws.rasmooplus.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record UserRequest(
        @NotBlank(message = "O campo nome não pode ser nulo ou vazio")
        String name,

        @NotBlank(message = "O campo email não pode ser nulo ou vazio")
        @Email(message = "O campo email deve ser um email válido")
        String email,

        @Size(min = 11, max = 11, message = "O campo telefone deve ter 11 caracteres")
        String phone,

        @CPF(message = "O campo cpf deve ser um cpf válido")
        String cpf,

        @NotNull
        Long userTypeId,

        @NotNull
        Long subscriptionTypeId
) {
}
