package com.hackathon.youngandrich.category.model.response;

import com.hackathon.youngandrich.category.model.entity.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryCreateResponse {
    private int userCategoryId;

    public static CategoryCreateResponse from(Category category) {
        return builder()
                .userCategoryId(category.getUserCategoryId())
                .build();
    }
}
