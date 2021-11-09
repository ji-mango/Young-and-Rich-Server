package com.hackathon.youngandrich.category.service;

import com.hackathon.youngandrich.category.model.entity.Category;
import com.hackathon.youngandrich.category.model.response.CategoryResponse;
import com.hackathon.youngandrich.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    // 유저 카테고리(플래너) 조회
    public List<CategoryResponse> getCategory(long userId) {
        return categoryRepository.getCategory(userId);
    }

    // 유저 카테고리(플래서) 추가
    public Boolean createCategory(Category category) {
        return categoryRepository.createCategory(category);
    }
}
