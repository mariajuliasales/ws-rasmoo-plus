package com.mariajulia.client.ws.rasmooplus.mapper;

import com.mariajulia.client.ws.rasmooplus.dto.request.SubscriptionTypeRequest;
import com.mariajulia.client.ws.rasmooplus.dto.response.SubscriptionTypeResponse;
import com.mariajulia.client.ws.rasmooplus.model.SubscriptionType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SubscriptionTypeMapper {

    public static SubscriptionType toSubscriptionType(SubscriptionTypeRequest request) {
        return SubscriptionType.builder()
                .name(request.name())
                .accessMonths(request.accessMonths())
                .price(request.prince())
                .productKey(request.productKey())
                .build();
    }

    public static SubscriptionTypeResponse toSubscriptionTypeResponse(SubscriptionType subscriptionType) {
        return SubscriptionTypeResponse.builder()
                .id(subscriptionType.getId())
                .name(subscriptionType.getName())
                .accessMonths(subscriptionType.getAccessMonths())
                .price(subscriptionType.getPrice())
                .productKey(subscriptionType.getProductKey())
                .build();
    }

}