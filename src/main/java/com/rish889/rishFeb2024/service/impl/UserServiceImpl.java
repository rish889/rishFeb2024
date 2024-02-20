package com.rish889.rishFeb2024.service.impl;

import com.rish889.rishFeb2024.exception.BadRequestException;
import com.rish889.rishFeb2024.exception.ErrorDetail;
import com.rish889.rishFeb2024.model.User;
import com.rish889.rishFeb2024.repository.UserRepository;
import com.rish889.rishFeb2024.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        if ("Error".equalsIgnoreCase(user.getName())) {
            throw new BadRequestException("invalid_username", "Username is not valid");
        }
        if ("Errors".equalsIgnoreCase(user.getName())) {
            throw new BadRequestException(Arrays.asList(
                    ErrorDetail.builder().errorCode("invalid_username").message("Username is not valid 1").build(),
                    ErrorDetail.builder().errorCode("invalid_username").message("Username is not valid 2").build()
            ));
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUsers() {
        return userRepository.findAll();
    }
}
