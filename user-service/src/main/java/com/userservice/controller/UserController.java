package com.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.response.UserResponse;
import com.userservice.response.VerifyUserPasswordResponse;
import com.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public UserResponse findUser(@PathVariable String  username){
        return userService.getUserDetails(username);
    }

    @PostMapping("/{username}/password-verify")
    public VerifyUserPasswordResponse verifyUserPasswordResponse(
        @PathVariable String username, @RequestBody String userPassword){

        VerifyUserPasswordResponse verifyUserPasswordResponse = new VerifyUserPasswordResponse(false);

        UserResponse userResponse = userService.getUserDetails(username,userPassword);
        if (userResponse !=null){
            verifyUserPasswordResponse.setStatus(true);
        }
        return verifyUserPasswordResponse;
    }
}
