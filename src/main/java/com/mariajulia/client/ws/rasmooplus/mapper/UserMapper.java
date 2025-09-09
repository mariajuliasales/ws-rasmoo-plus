package com.mariajulia.client.ws.rasmooplus.mapper;


import com.mariajulia.client.ws.rasmooplus.dto.request.UserRequest;
import com.mariajulia.client.ws.rasmooplus.dto.response.UserResponse;
import com.mariajulia.client.ws.rasmooplus.model.SubscriptionType;
import com.mariajulia.client.ws.rasmooplus.model.User;
import com.mariajulia.client.ws.rasmooplus.model.UserType;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request, UserType userType, SubscriptionType subscriptionType) {
        LocalDate today = LocalDate.now();
        return User.builder()
                .name(request.name())
                .email(request.email())
                .phone(request.phone())
                .cpf(request.cpf())
                .dtExpiration(today.plusYears(1))
                .userType(userType)
                .subscriptionType(subscriptionType)
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .cpf(user.getCpf())
                .dtSubscription(user.getDtSubscription())
                .dtExpiration(user.getDtExpiration())
                .userType(user.getUserType().getName())
                .subscriptionType(user.getSubscriptionType().getName())
                .build();
    }

}
