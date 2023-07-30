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

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.compass_aac.view.adapters.PassCategoryAdapter
import com.example.compass_aac.databinding.ActivityPassCategoryBinding
import com.example.compass_aac.viewmodel.PassCategoryViewModel
import com.example.compass_aac.view.MainActivity
import com.example.compass_aac.view.location.SearchLocation
import com.example.compass_aac.view.login.TitleActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PassCategory : AppCompatActivity() {

    private var backPressedTime: Long = 0

    //뒤로 가기 두번 누르면 로그아웃되고 다시 로그인 하는 창으로 이동
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val currentTime = System.currentTimeMillis()
            val intervalTime = currentTime - backPressedTime

            if (intervalTime in 0..2000) {
                val intent = Intent(this@PassCategory, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            } else {
                backPressedTime = currentTime
                Toast.makeText(applicationContext, "뒤로가기 버튼을 한번 더 누르면 메인으로 이동합니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    // PassCategoryViewModel
    private val viewModel: PassCategoryViewModel by viewModels()

    // ViewBinding 객체 선언
    private lateinit var binding: ActivityPassCategoryBinding

    //콜백 인스턴스 생성
    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            // 뒤로 버튼 이벤트 처리
            Log.e(TAG, "뒤로가기 클릭")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityPassCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback) //위에서 생성한 콜백 인스턴스 붙여주기

        // ViewModel
//        viewModel = ViewModelProvider(this).get(PassCategoryViewModel::class.java)


        // intent로부터 categoryData를 받아 ViewModel에 전달
        val categoryData = intent.getStringExtra("category")
//        val categories = categoryData!!.split(",")
        if (categoryData != null) {
            viewModel.initCategoryData(categoryData)
        } else {
            Toast.makeText(this, "카테고리 데이터가 없습니다.", Toast.LENGTH_SHORT).show()
        }

        val categories = listOf("카페", "학교", "도서관", "박윤찬", "멍청이", "똥쟁이", "꿀빤다","카페", "학교", "도서관", "박윤찬", "멍청이", "똥쟁이", "꿀빤다")

        // Adapter 생성 및 설정
        val adapter = PassCategoryAdapter(categories)

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter




        // ViewModel에서 LiveData를 관찰하여 데이터가 변경될 때마다 GridView를 업데이트
        viewModel.categoryResult.observe(this) { result ->
            if (result != null) {
                adapter.submitList(categories) //업데이트
            } else {
                Toast.makeText(this, "카테고리를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.researchBtn.setOnClickListener {
            val intent =  Intent(this, SearchLocation::class.java)
            startActivity(intent)
        }


    }

}