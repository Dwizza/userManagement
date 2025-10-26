package com.exemple.userMgmt.web;


import com.exemple.userMgmt.dto.UserDtoRequest;
import com.exemple.userMgmt.dto.UserDtoResponse;
import com.exemple.userMgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserWeb {

    private final UserService userService;


    @Autowired
    public UserWeb(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDtoResponse createUser(@RequestBody UserDtoRequest userDTO) {

        return userService.createUser(userDTO);
    }

    @GetMapping("/all")
    public List<UserDtoResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserDtoResponse updateUser(@PathVariable Long id, @RequestBody UserDtoRequest userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}