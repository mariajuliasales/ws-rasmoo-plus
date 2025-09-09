package com.mariajulia.client.ws.rasmooplus.service;

import com.mariajulia.client.ws.rasmooplus.model.UserType;

import java.util.List;

public interface UserTypeService {

    UserType create(UserType userType);

    List<UserType> findAll();

    UserType findById(Long id);

    UserType update(Long id, UserType userType);

    void deleteById(Long id);

}
