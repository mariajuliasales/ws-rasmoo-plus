package com.mariajulia.client.ws.rasmooplus.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SubscriptionTypeResponse(Long id,
                                       String name,
                                       Long accessMonths,
                                       BigDecimal price,
                                       String productKey) {
}