package com.hackathon.youngandrich.category.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryListResponse {
    private List<CategoryResponse> categoryList;
    public static CategoryListResponse from(List<CategoryResponse> categoryList) {
        return builder()
                .categoryList(categoryList)
                .build();
    }
}
