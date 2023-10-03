package com.example.compass_aac.view

fun ConvertToId(selectedCategory: String) : Int {
    val result = when(selectedCategory){
        "문구점" -> 101
        "식당" -> 102
        "영화관" -> 103
        "마트" -> 104
        "편의점" -> 105
        "도서관" -> 106
        "카페" -> 107
        "미용실" -> 108
        "서점" -> 109
        "병원" -> 100
        else -> 0
    }

    return result
}