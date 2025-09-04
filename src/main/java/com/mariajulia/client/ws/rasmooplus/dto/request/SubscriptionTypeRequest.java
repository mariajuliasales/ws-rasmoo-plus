package com.mariajulia.client.ws.rasmooplus.dto.request;

import java.math.BigDecimal;

public record SubscriptionTypeRequest(String name,
                                      Long accessMonths,
                                      BigDecimal prince,
                                      String productKey) {
}