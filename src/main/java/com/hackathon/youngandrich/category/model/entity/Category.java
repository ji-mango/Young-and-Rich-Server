package com.hackathon.youngandrich.category.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    private int userCategoryId;
    private int categoryId;
    private int accountId;
    private int setPrice;
    private int setMonth;
    private int status;
}
