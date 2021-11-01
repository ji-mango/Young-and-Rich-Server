package com.hackathon.youngandrich.user.repository;

import com.hackathon.youngandrich.user.mapper.UserMapper;
import com.hackathon.youngandrich.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final UserMapper userMapper;

    public User test() {
        return userMapper.test();
    }
}
