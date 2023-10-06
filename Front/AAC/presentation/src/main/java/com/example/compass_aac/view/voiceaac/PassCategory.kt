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

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.compass_aac.view.adapters.PassCategoryAdapter
import com.example.compass_aac.databinding.ActivityPassCategoryBinding
import com.example.compass_aac.viewmodel.voiceaac.PassCategoryViewModel
import com.example.compass_aac.view.MainActivity
import com.example.compass_aac.view.adapters.NodeAdapter
import com.example.compass_aac.view.location.SearchLocation
import com.example.data.source.remote.Tree_Node
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PassCategory : AppCompatActivity() {

    //어댑터에 연결할 카테고리 리스트
    private var categorylist :List<String> = listOf()
//    private lateinit var adapter : PassCategoryAdapter

    private lateinit var newCategory : String
    private var backPressedTime: Long = 0


    //콜백 인스턴스 생성
    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            // 뒤로 버튼 이벤트 처리
            Log.e(TAG, "뒤로가기 클릭")
        }
    }

    //뒤로 가기 두번 누르면 로그아웃되고 다시 로그인 하는 창으로 이동
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val currentTime = System.currentTimeMillis()
            val intervalTime = currentTime - backPressedTime

            if (intervalTime in 0..2000) {
                val intent = Intent(this@PassCategory, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                onDestroy()
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityPassCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback) //위에서 생성한 콜백 인스턴스 붙여주기
        newCategory = ""

        // intent로부터 categoryData를 받아 ViewModel에 전달
        var categoryData = intent.getStringExtra("CATEGORY") ?: "default"
        Log.d("categoryData", categoryData)

        viewModel.receiveCategory(categoryData)

//        viewModel.receivedCategory.observe(this){
//            categoryData = it
//        }


        val existPlace : ArrayList<String> = arrayListOf("문구점", "식당", "영화관","마트","편의점", "도서관","카페","미용실", "서점","병원")
        //해당 위치에 대한 정보가 없는 경우
        when (categoryData) {
            "default" -> {
                newCategory = "default"
                //          viewModel.initCategoryData(categoryData)
                Log.d("newCategory1", newCategory)

                categorylist = viewModel.defaultprocessNodes(newCategory)
            }
            //장소는 잘 나오지만 json에 해당 카테고리가 없는 경우
            !in existPlace -> {
                newCategory = "default"
                Log.d("newCategory2", newCategory)
                categorylist = viewModel.defaultprocessNodes(newCategory)

            }
            //해당 위치에 대한 장소가 잘 나온 경우
            else -> {
                Log.d("newCategory3", categoryData)
                categorylist= viewModel.processNodes(categoryData)
            }
        }




        // Adapter 생성 및 설정
        val adapter = PassCategoryAdapter(categorylist)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter



        binding.researchBtn.setOnClickListener {
            val intent =  Intent(this, SearchLocation::class.java)
            startActivity(intent)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }

}