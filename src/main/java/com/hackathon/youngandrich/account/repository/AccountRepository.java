package com.hackathon.youngandrich.account.repository;

import com.hackathon.youngandrich.account.mapper.AccountMapper;
import com.hackathon.youngandrich.account.model.response.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class AccountRepository {
    private final AccountMapper accountMapper;

    // 유저 카테고리(플래너)조회 API
    public List<AccountResponse> getAccount(long userId) {
        return accountMapper.getAccount(userId);
    }
}
