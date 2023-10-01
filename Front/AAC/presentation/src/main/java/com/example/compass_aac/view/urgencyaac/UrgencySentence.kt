package com.example.compass_aac.view.urgencyaac

import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityUrgencySentenceBinding
import com.example.compass_aac.view.adapters.NodeAdapter
import com.example.compass_aac.view.adapters.UrgencyAdapter
import com.example.compass_aac.viewmodel.urgencyaac.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException

@AndroidEntryPoint
class UrgencySentence : AppCompatActivity() {

    private lateinit var adapter: UrgencyAdapter

    private lateinit var viewModel : CategoryViewModel

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            finish()
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }

//    private val viewModel : CategoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityUrgencySentenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ViewModel
        viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]

        //위에서 생성한 콜백 인스턴스 붙여주기
        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        val category = intent.getStringExtra("category")?: "null"
        Log.d("category", category)
        binding.selectedCategory.text = category

        val getSentence =  viewModel.getSentence(CategoryId(category))
        adapter = UrgencyAdapter(getSentence, this)
        binding.urgencyRecycler.layoutManager = LinearLayoutManager(this)
        binding.urgencyRecycler.adapter = adapter


        binding.imageButton2.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()

        }

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