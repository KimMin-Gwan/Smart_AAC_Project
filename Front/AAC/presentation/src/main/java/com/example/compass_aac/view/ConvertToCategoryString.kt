package com.example.compass_aac.view

import android.util.Log

fun ConvertToCategoryString(categoryId: List<Int>) : List<String> {

    val categoryString: MutableList<String> = mutableListOf()
    for (category in categoryId){
        val result = when(category){
            101 -> "문구점"
            102 -> "식당"
            103 -> "영화관"
            104 -> "마트"
            105 -> "편의점"
            106 -> "도서관"
            107 -> "카페"
            108 -> "미용실"
            109 -> "서점"
            100 -> "병원"
            else -> "카테고리 없음 "
        }

        categoryString.add(result)
    }
    return categoryString

    return categoryString
}