package com.rish889.rishFeb2024.mapper;

import com.rish889.rishFeb2024.dto.user.UserRequestDto;
import com.rish889.rishFeb2024.dto.user.UserResponseDto;
import com.rish889.rishFeb2024.model.User;


public class UserMapper {
    public static User convertToEntity(final UserRequestDto dto) {
        final User entity = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
        return entity;
    }

    public static UserResponseDto convertDto(final User entity) {
        final UserResponseDto dto = UserResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
        return dto;
    }
}
