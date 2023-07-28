/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 위치 탐색 기반으로 나오는 장소 카테고리 화면 (어디든 PASS)
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/


package com.example.compass_aac.view.voiceaac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.compass_aac.view.adapters.PassCategoryAdapter
import com.example.compass_aac.databinding.ActivityPassCategoryBinding
import com.example.compass_aac.viewmodel.PassCategoryViewModel
import com.example.compass_aac.view.MainActivity

class PassCategory : AppCompatActivity() {

    // PassCategoryViewModel 객체 선언
    private lateinit var viewModel: PassCategoryViewModel

    // ViewBinding 객체 선언
    private lateinit var binding: ActivityPassCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityPassCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // ViewModel 초기화
        viewModel = ViewModelProvider(this).get(PassCategoryViewModel::class.java)

        // Adapter 생성 및 설정
        val adapter = PassCategoryAdapter(this, ArrayList())
        binding.passCategoryGridview.adapter = adapter

        // ViewModel에서 LiveData를 관찰하여 데이터가 변경될 때마다 GridView를 업데이트
        viewModel.categoryResult.observe(this) { result ->
            val categories = result.getOrNull()
            if (categories != null) {
                adapter.clear()
                adapter.addAll(categories)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "카테고리를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
        }


        // intent로부터 categoryData를 받아 ViewModel에 전달
        val categoryData = intent.getStringExtra("category")
        if (categoryData != null) {
            viewModel.initCategoryData(categoryData)
        } else {
            Toast.makeText(this, "카테고리 데이터가 없습니다.", Toast.LENGTH_SHORT).show()
        }


    }

    //뒤로가기
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}