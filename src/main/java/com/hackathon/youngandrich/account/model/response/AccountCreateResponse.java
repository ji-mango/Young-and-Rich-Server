package com.hackathon.youngandrich.account.model.response;

import com.hackathon.youngandrich.account.model.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountCreateResponse {
    private int accountId;

    public static AccountCreateResponse from(Account account) {
        return builder()
                .accountId(account.getAccountId())
                .build();
    }
}
