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

    // 이메일 중복체크
    public Boolean checkUserEmail(String email) {
        return userRepository.checkUserEmail(email);
    }

    // 회원가입
    public boolean signUp(User user) {return userRepository.signUp(user);}

}
