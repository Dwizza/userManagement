package com.exemple.userMgmt.service;


import com.exemple.userMgmt.domain.User;
import com.exemple.userMgmt.dto.UserDtoRequest;
import com.exemple.userMgmt.dto.UserDtoResponse;
import com.exemple.userMgmt.mapper.UserMapper;
import com.exemple.userMgmt.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDtoResponse createUser(UserDtoRequest dto){
        User toSave = UserMapper.toEntity(dto);
        User saved = userRepository.save(toSave);
        return userMapper.toDto(saved);
    }

    public List<UserDtoResponse> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDtoResponse> responses = new ArrayList<>();
        for (User user : users) {
            responses.add(userMapper.toDto(user));
        }
        return responses;
    }

    public UserDtoResponse updateUser(Long id, UserDtoRequest dto) {
        User existing = userRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(dto.getName());
            existing.setEmail(dto.getEmail());
            existing.setPassword(dto.getPassword());
            existing.setRole(dto.getRole());
            existing.setActive(dto.getActive());
            User saved = userRepository.save(existing);
            return userMapper.toDto(saved);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
