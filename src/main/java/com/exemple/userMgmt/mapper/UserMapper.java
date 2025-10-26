package com.exemple.userMgmt.mapper;

import com.exemple.userMgmt.domain.User;
import com.exemple.userMgmt.dto.UserDtoRequest;
import com.exemple.userMgmt.dto.UserDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User toEntity(UserDtoRequest dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setActive(dto.getActive());
        return user;
    }

    public UserDtoResponse toDto(User user) {
        UserDtoResponse dto = new UserDtoResponse();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setActive(user.getActive());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }
}
