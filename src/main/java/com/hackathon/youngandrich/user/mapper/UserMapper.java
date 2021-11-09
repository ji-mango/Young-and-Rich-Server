package com.hackathon.youngandrich.user.mapper;

import com.hackathon.youngandrich.user.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    // 로그인 API
    int login(User user);

    // 이메일 중복체크 API
    Integer checkUserEmail (String email);
}
