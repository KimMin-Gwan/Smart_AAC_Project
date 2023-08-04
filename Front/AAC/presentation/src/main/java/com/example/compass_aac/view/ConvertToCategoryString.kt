package com.example.compass_aac.view

import android.util.Log

fun ConvertToCategoryString(categoryId: List<Int>) : List<String> {

    val categoryString: MutableList<String> = mutableListOf()
    for (category in categoryId){
        val result = when(category){
            101 -> "편의점"
            102 -> "문구점"
            103 -> "영화관"
            104 -> "마트"
            105 -> "도서관"
            106 -> "카페"
            107 -> "서점"
            108 -> "미용실"
            109 -> "식당"
            else -> "카테고리 없음 "
        }

        categoryString.add(result)
    }
    return categoryString

    return categoryString
}