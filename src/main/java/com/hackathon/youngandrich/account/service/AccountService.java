package com.hackathon.youngandrich.account.service;

import com.hackathon.youngandrich.account.model.response.AccountResponse;
import com.hackathon.youngandrich.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    // 유저 카테고리(플래너 조회)
    public List<AccountResponse> getAccount(long userId) {
        return accountRepository.getAccount(userId);
    }
}
