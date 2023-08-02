package com.example.domain.repository

interface FindNodeRepository {

     fun returnIndex(Category: String) :Int

     fun MakeTree(index: Int) : MutableList<String>



}