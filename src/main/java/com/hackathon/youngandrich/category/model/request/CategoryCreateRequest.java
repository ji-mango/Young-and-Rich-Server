package com.hackathon.youngandrich.category.model.request;

import com.hackathon.youngandrich.category.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryCreateRequest {

    @NotNull
    private int categoryId;

    @NotNull
    private int accountId;

    @NotNull
    private int setPrice;

    public Category toCategory() {
        Category category = new Category();

        category.setCategoryId(getCategoryId());
        category.setAccountId(getAccountId());
        category.setSetPrice(getSetPrice());
        return category;
    }
}
