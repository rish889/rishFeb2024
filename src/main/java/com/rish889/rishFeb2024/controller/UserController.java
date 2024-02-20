package com.rish889.rishFeb2024.controller;

import com.rish889.rishFeb2024.dto.user.UserRequestDto;
import com.rish889.rishFeb2024.dto.user.UserResponseDto;
import com.rish889.rishFeb2024.mapper.UserMapper;
import com.rish889.rishFeb2024.model.User;
import com.rish889.rishFeb2024.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<UserResponseDto> addNewUser(@Valid @RequestBody UserRequestDto dto) {
        final User user = userRepository.save(UserMapper.convertToEntity(dto));
        return ResponseEntity.ok(UserMapper.convertDto(user));
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
