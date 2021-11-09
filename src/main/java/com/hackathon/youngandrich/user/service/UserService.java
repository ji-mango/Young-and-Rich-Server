package com.hackathon.youngandrich.user.service;

import com.hackathon.youngandrich.user.model.entity.User;
import com.hackathon.youngandrich.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 로그인
    public int login(User user) {
        return userRepository.login(user);
    }
}
