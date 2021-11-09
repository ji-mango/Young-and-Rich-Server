package com.hackathon.youngandrich.category.mapper;

import com.hackathon.youngandrich.category.model.response.CategoryResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    // 유저 카테고리(플래너)조회 API
    List<CategoryResponse> getCategory(@Param("userId") long userId);
}
