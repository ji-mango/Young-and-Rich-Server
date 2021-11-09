package com.hackathon.youngandrich.category.repository;

import com.hackathon.youngandrich.category.mapper.CategoryMapper;
import com.hackathon.youngandrich.category.model.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CategoryRepository {
    private final CategoryMapper categoryMapper;

    // 유저 카테고리(플래너)조회 API
    public List<CategoryResponse> getCategory(long userId) {
        return categoryMapper.getCategory(userId);
    }
}
