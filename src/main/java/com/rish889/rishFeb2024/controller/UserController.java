package com.rish889.rishFeb2024.controller;

import com.rish889.rishFeb2024.config.ApiPaths;
import com.rish889.rishFeb2024.dto.user.UserRequestDto;
import com.rish889.rishFeb2024.dto.user.UserResponseDto;
import com.rish889.rishFeb2024.mapper.UserMapper;
import com.rish889.rishFeb2024.model.User;
import com.rish889.rishFeb2024.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(ApiPaths.USERS)
    public @ResponseBody ResponseEntity<UserResponseDto> saveUser(@Valid @RequestBody UserRequestDto requestDto) {
        log.info("saveUser(). requestDto : {}", requestDto);
        final User user = userRepository.save(UserMapper.convertToEntity(requestDto));

        final UserResponseDto responseDto = UserMapper.convertDto(user);
        log.info("saveUser() successful. responseDto : {}", responseDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(ApiPaths.USERS)
    public @ResponseBody ResponseEntity<List<UserResponseDto>> fetchUsers() {
        log.info("fetchUsers().");
        final List<User> users = userRepository.findAll();

        final List<UserResponseDto> responseDto = users.stream().map(user -> UserMapper.convertDto(user)).collect(Collectors.toList());
        log.info("fetchUsers() successful. responseDto : {}", responseDto);
        return ResponseEntity.ok(responseDto);
    }
}
