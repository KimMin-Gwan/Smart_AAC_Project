package com.example.compass_aac.view

fun ConvertToId(selectedCategory: String) : Int {
    val result = when(selectedCategory){
        "도서관" -> 101
        "마트" -> 102
        "카페" -> 103
        "미용실" -> 104
        "문구점" -> 105
        "서점" -> 106
        "편의점" -> 107
        "식당" -> 108
        "영화관" -> 109
        else -> 0
    }

    return result
}