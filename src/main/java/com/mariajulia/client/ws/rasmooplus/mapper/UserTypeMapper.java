package com.mariajulia.client.ws.rasmooplus.mapper;

import com.mariajulia.client.ws.rasmooplus.dto.request.UserTypeRequest;
import com.mariajulia.client.ws.rasmooplus.dto.response.UserTypeResponse;
import com.mariajulia.client.ws.rasmooplus.model.UserType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTypeMapper {

    public static UserType toUserType(UserTypeRequest request) {
        return UserType.builder()
                .name(request.name())
                .description(request.description())
                .build();
    }

    public static UserTypeResponse toUserTypeResponse(UserType userType) {
        return UserTypeResponse.builder()
                .id(userType.getId())
                .name(userType.getName())
                .description(userType.getDescription())
                .build();
    }
}
