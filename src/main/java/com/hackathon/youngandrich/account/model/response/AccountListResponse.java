package com.hackathon.youngandrich.account.model.response;

import com.hackathon.youngandrich.account.model.entity.Account;
import com.hackathon.youngandrich.category.model.response.CategoryListResponse;
import com.hackathon.youngandrich.category.model.response.CategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountListResponse {
    private List<AccountResponse> accountList;
    public static AccountListResponse from(List<AccountResponse> accountList) {
        return builder()
                .accountList(accountList)
                .build();
    }
}
