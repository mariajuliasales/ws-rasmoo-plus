package com.mariajulia.client.ws.rasmooplus.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record SubscriptionTypeRequest(@NotBlank(message = "O campo nome não pode ser nulo ou vazio")
                                      @Size(min = 5, max = 50, message = "O campo nome deve ter no máximo 50 caracteres")
                                      String name,

                                      @Max(value = 12, message = "O número máximo de meses é 12")
                                      Long accessMonths,

                                      @NotNull(message = "O campo preço não pode ser nulo")
                                      BigDecimal prince,

                                      @NotBlank(message = "O campo productKey não pode ser nulo ou vazio")
                                      @Size(min = 5, max = 15, message = "O campo productKey deve ter no minimo 5 e no maximo 15 caracteres")
                                      String productKey) {
}