package com.hackathon.youngandrich.account.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private int accountId;
    private int userId;
    private String accountNum;
    private String cardName;
    private int price;
    private Timestamp createdAt;
    private int status;
}
