package com.example.compass_aac.view

fun ConvertCategoryId(categoryresult: List<String>) : List<Int> {


    val categoryStringToId : MutableList<Int> = mutableListOf()

    for (category in categoryresult){

        val result : Int = when(category){
            "문구점" -> 101
            "식당" -> 102
            "영화관" -> 103
            "마트" -> 104
            "편의점" -> 105
            "도서관" -> 106
            "카페" -> 107
            "미용실" -> 108
            "서점" -> 109
            else -> 0
        }

        categoryStringToId.add(result)
    }


    return categoryStringToId
}