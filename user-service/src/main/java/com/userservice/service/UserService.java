package com.userservice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.userservice.model.User;
import com.userservice.repository.UserRepository;
import com.userservice.response.UserResponse;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserResponse getUserDetails(String email){

        UserResponse userResponse = new UserResponse();
        User user = userRepository.findByUserEmail(email);
        if (user == null){
            return userResponse;
        }
        BeanUtils.copyProperties(user, userResponse);
        return userResponse;
    }

    public UserResponse getUserDetails(String email, String password){

        UserResponse userResponse = new UserResponse();

        User byUserEmail = userRepository.findByUserEmail(email);
        if (byUserEmail == null){
            return userResponse;
        }
        if (bCryptPasswordEncoder.matches(password, byUserEmail.getEncryptedPassword())){
            System.out.println("Password matches!!");
            userResponse = new UserResponse();
            BeanUtils.copyProperties(byUserEmail, userResponse);
        }
        return userResponse;
    }

}
