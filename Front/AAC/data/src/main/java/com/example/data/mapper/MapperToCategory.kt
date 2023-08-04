package com.example.data.mapper

import com.example.data.model.remote.CategoryResponse
import com.example.domain.model.Categories
import retrofit2.Response

fun MapperToCategory(category : CategoryResponse) : Categories {
    return Categories(category.category)

}