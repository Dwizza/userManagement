package com.exemple.userMgmt.service;


import com.exemple.userMgmt.domain.User;
import com.exemple.userMgmt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(Long id, User userDetails) {
        User existing = userRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(userDetails.getName());
            existing.setEmail(userDetails.getEmail());
            return userRepository.save(existing);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
