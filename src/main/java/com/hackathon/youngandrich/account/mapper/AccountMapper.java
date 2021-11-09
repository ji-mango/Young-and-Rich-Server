package com.hackathon.youngandrich.account.mapper;

import com.hackathon.youngandrich.account.model.response.AccountResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper {

    // 유저 카테고리(플래너)조회 API
    List<AccountResponse> getAccount(@Param("userId") long userId);
}
