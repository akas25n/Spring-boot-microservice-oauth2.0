package com.userservice;

import javax.transaction.Transactional;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.userservice.model.User;
import com.userservice.repository.UserRepository;

@Component
public class PrimaryData {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public PrimaryData(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @EventListener
    @Transactional
    public void onAppEvent(ApplicationReadyEvent applicationReadyEvent){
        User user = new User(1L,
            "hkahjkf",
            "Abdur",
            "Rahim",
            "abdur.rahim@testmail.com",
            bCryptPasswordEncoder.encode("rahim"),
            "",
            false);

        userRepository.save(user);
    }
}
