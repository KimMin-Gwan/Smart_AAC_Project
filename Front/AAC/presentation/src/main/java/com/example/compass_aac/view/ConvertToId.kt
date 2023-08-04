package com.example.compass_aac.view

fun ConvertToId(selectedCategory: String) : Int {
    val result = when(selectedCategory){
        "도서관" -> 101
        "카페" -> 102
        "문구점" -> 103
        "영화관" -> 104
        "식당" -> 105
        "서점" -> 106
        "마트" -> 107
        "미용실" -> 108
        "편의점" -> 109
        else -> 0
    }

    return result
}