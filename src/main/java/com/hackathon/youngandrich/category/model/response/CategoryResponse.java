package com.hackathon.youngandrich.category.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CategoryResponse {
    private int userCategoryId;
    private int accountId;
    private String categoryName;
    private int setPrice;
    private int usedPrice;
}