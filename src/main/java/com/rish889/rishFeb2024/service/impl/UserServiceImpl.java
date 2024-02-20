package com.rish889.rishFeb2024.service.impl;

import com.rish889.rishFeb2024.model.User;
import com.rish889.rishFeb2024.repository.UserRepository;
import com.rish889.rishFeb2024.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUsers() {
        return userRepository.findAll();
    }
}
