package com.mariajulia.client.ws.rasmooplus.controller;

import com.mariajulia.client.ws.rasmooplus.dto.request.UserRequest;
import com.mariajulia.client.ws.rasmooplus.dto.response.UserResponse;
import com.mariajulia.client.ws.rasmooplus.mapper.UserMapper;
import com.mariajulia.client.ws.rasmooplus.model.SubscriptionType;
import com.mariajulia.client.ws.rasmooplus.model.UserType;
import com.mariajulia.client.ws.rasmooplus.service.SubscriptionTypeService;
import com.mariajulia.client.ws.rasmooplus.service.UserService;
import com.mariajulia.client.ws.rasmooplus.service.UserTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    public final UserService userService;
    public final UserTypeService userTypeService;
    public final SubscriptionTypeService subscriptionTypeService;

    public UserController(UserService userService, UserTypeService userTypeService, SubscriptionTypeService subscriptionTypeService) {
        this.userService = userService;
        this.userTypeService = userTypeService;
        this.subscriptionTypeService = subscriptionTypeService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest userRequest) {

        UserType userType = userTypeService.findById(userRequest.userTypeId());
        SubscriptionType subscriptionType = subscriptionTypeService.findById(userRequest.subscriptionTypeId());

        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(
                userService.create(UserMapper.toUser(userRequest, userType, subscriptionType))));

    }
}
