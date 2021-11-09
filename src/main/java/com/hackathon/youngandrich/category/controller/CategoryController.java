package com.hackathon.youngandrich.category.controller;

import com.hackathon.youngandrich.category.model.entity.Category;
import com.hackathon.youngandrich.category.model.request.CategoryCreateRequest;
import com.hackathon.youngandrich.category.model.response.CategoryCreateResponse;
import com.hackathon.youngandrich.category.model.response.CategoryListResponse;
import com.hackathon.youngandrich.category.model.response.CategoryResponse;
import com.hackathon.youngandrich.category.service.CategoryService;
import com.hackathon.youngandrich.common.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class CategoryController {
    private final CategoryService categoryService;

    // 유저 카테고리(플래너)조회 API
    @GetMapping("/{userId}/category")
    public ResponseMessage<CategoryListResponse> getCategory(@PathVariable("userId") @Positive long userId) {
        List<CategoryResponse> categoryList = categoryService.getCategory(userId);

        return new ResponseMessage<>(CategoryListResponse.from(categoryList));

    }

    // 유저 카테고리(플래너) 추가 API
    @PostMapping("/category")
    public ResponseMessage<CategoryCreateResponse> createCategory(@RequestBody @Valid CategoryCreateRequest categoryCreateRequest) {
        Category category = categoryCreateRequest.toCategory();
        Boolean result = categoryService.createCategory(category);
        if(result == false)
            return new ResponseMessage<>("이미 존재하는 카테고리입니다.");
        else
            return new ResponseMessage<>(CategoryCreateResponse.from(category));

    }

}