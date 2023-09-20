package com.example.compass_aac.view.urgencyaac

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityUrgencySentenceBinding
import com.example.compass_aac.viewmodel.urgencyaac.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException

@AndroidEntryPoint
class UrgencySentence : AppCompatActivity() {

    private lateinit var viewModel : CategoryViewModel

//    private val viewModel : CategoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityUrgencySentenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ViewModel
        viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]


        val category = intent.getStringExtra("category")?: "null"
        Log.d("category", category)
        binding.selectedCategory.text = category

        viewModel.getSentence(CategoryId(category))


    }
    private fun CategoryId(category:String) : Int{
        val result = when(category){
            "의료 상황" -> 501
            "안전/위험 상황" -> 502
            "위치/실종 상황" -> 503
            else -> 504
        }
        return result
    }
}