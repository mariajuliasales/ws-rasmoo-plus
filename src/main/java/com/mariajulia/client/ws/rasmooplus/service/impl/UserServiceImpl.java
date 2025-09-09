package com.mariajulia.client.ws.rasmooplus.service.impl;

import com.mariajulia.client.ws.rasmooplus.exception.NotFoundException;
import com.mariajulia.client.ws.rasmooplus.model.User;
import com.mariajulia.client.ws.rasmooplus.model.UserType;
import com.mariajulia.client.ws.rasmooplus.repository.UserRepository;
import com.mariajulia.client.ws.rasmooplus.repository.UserTypeRepository;
import com.mariajulia.client.ws.rasmooplus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserTypeRepository userTypeRepository;

    public UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public User create(User user) {

        var userTypeOpt = userTypeRepository.findById(user.getUserType().getId());
        if (userTypeOpt.isEmpty()) {
            throw new NotFoundException("UserType não encontrado");
        }

        UserType userType = userTypeOpt.get();
        user.setUserType(userType);

        return userRepository.save(user);
    }
}
