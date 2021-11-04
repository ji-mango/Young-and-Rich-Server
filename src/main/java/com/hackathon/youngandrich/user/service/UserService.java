package com.hackathon.youngandrich.user.service;

import com.hackathon.youngandrich.user.model.entity.User;
import com.hackathon.youngandrich.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User test() {
        return userRepository.test();
    }
}
