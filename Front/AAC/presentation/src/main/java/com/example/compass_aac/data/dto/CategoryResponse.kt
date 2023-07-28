package com.example.compass_aac.data.dto

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("category")
    val category: String
)