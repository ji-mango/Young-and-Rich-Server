package com.hackathon.youngandrich.user.repository;

import com.hackathon.youngandrich.user.mapper.UserMapper;
import com.hackathon.youngandrich.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final UserMapper userMapper;

    // 로그인 API
    public int login(User user) {
        return userMapper.login(user);
    }
}
