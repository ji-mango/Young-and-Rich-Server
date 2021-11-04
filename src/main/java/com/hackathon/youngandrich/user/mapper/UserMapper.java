package com.hackathon.youngandrich.user.mapper;

import com.hackathon.youngandrich.user.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User test();
}
