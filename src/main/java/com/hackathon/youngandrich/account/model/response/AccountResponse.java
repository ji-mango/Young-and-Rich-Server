package com.hackathon.youngandrich.account.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountResponse {
    private int accountId;
    private String accountNum;
    private String cardName;
    private int price;
}
