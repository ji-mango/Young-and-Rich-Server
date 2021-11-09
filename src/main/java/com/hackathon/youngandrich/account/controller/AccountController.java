package com.hackathon.youngandrich.account.controller;

import com.hackathon.youngandrich.account.model.response.AccountListResponse;
import com.hackathon.youngandrich.account.model.response.AccountResponse;
import com.hackathon.youngandrich.account.service.AccountService;
import com.hackathon.youngandrich.common.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class AccountController {
    private final AccountService accountService;

    // 카드(계좌)별 잔액조회 API
    @GetMapping("/{userId}/accounts")
    public ResponseMessage<AccountListResponse> getAccount(@PathVariable("userId") @Positive long userId) {
        List<AccountResponse> accountList = accountService.getAccount(userId);

        return new ResponseMessage<>(AccountListResponse.from(accountList));
    }

//    @PostMapping("/accounts")
//    public ResponseMessage<AccountCreateResponse> createAccount(@RequestBody @Valid AccountCreateRequest accountCreateRequest) {
//        Account account =
//    }

}