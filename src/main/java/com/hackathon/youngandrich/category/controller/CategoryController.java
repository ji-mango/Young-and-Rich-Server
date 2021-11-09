package com.hackathon.youngandrich.category.controller;

import com.hackathon.youngandrich.category.model.request.CategoryPostRequest;
import com.hackathon.youngandrich.category.model.response.CategoryListResponse;
import com.hackathon.youngandrich.category.model.response.CategoryPostResponse;
import com.hackathon.youngandrich.category.model.response.CategoryResponse;
import com.hackathon.youngandrich.category.service.CategoryService;
import com.hackathon.youngandrich.common.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    // 유저 카테고리(플래서)생성 API
//    @PostMapping("/{userId}/category")
//    public ResponseMessage<CategoryPostResponse> postCategory(@RequestParam @Valid CategoryPostRequest categoryPostRequest) {
//
//    }

}