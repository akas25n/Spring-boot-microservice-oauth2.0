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

    @GetMapping("/{email}")
    public UserResponse findUserByUserEmail(@PathVariable String  email){
        return userService.getUserDetails(email);
    }

    @PostMapping("/{email}/password-verify")
    public VerifyUserPasswordResponse verifyUserPasswordResponse(
        @PathVariable String email, @RequestBody String password){

        VerifyUserPasswordResponse verifyUserPasswordResponse = new VerifyUserPasswordResponse();

        UserResponse userResponse = userService.getUserDetails(email,password);
        if (userResponse !=null){
            verifyUserPasswordResponse.setResult(true);
        }
        return verifyUserPasswordResponse;
    }
}
