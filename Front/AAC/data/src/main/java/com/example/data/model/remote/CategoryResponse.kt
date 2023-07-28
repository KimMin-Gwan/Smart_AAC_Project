package com.example.data.model.remote


import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("category")
    val category: String
)