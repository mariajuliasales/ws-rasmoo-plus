package com.mariajulia.client.ws.rasmooplus.service.impl;

import com.mariajulia.client.ws.rasmooplus.exception.NotFoundException;
import com.mariajulia.client.ws.rasmooplus.model.UserType;
import com.mariajulia.client.ws.rasmooplus.repository.UserTypeRepository;
import com.mariajulia.client.ws.rasmooplus.service.UserTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository userTypeRepository;

    public UserTypeServiceImpl(UserTypeRepository userTypeRepository1) {
        this.userTypeRepository = userTypeRepository1;
    }

    @Override
    public UserType create(UserType userType) {
        return userTypeRepository.save(userType);
    }

    @Override
    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }

    @Override
    public UserType findById(Long id) {
        return getUserType(id);
    }

    @Override
    public UserType update(Long id, UserType userType) {

        return userTypeRepository.save(UserType.builder()
                .id(id)
                .name(userType.getName())
                .description(userType.getDescription())
                .build());
    }

    @Override
    public void deleteById(Long id) {
        getUserType(id);
        userTypeRepository.deleteById(id);
    }

    private UserType getUserType(Long id) {
        Optional<UserType> optionalUserType = userTypeRepository.findById(id);
        if (optionalUserType.isEmpty()) {
            throw new NotFoundException("UserType não encontrado");
        }
        return optionalUserType.get();
    }
}
