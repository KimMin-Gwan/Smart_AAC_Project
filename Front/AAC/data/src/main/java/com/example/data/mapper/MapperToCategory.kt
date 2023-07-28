package com.example.data.mapper

import com.example.data.model.remote.CategoryResponse
import com.example.domain.model.Categories

fun MapperToCategory(category : List<CategoryResponse>) : List<Categories> {
    return category.toList().map {
        Categories(
            it.category
        )
    }
}