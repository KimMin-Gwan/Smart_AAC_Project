/** Project : 2023 AAC Compass
* Program Purpose and Features :
* - 메인 홈화면: AI AAC, 일상 AAC, 긴급 AAC + 로그인 버튼
* Author : ES.KEE
* First Write Date : 2023.07.14
* ==========================================================================
* Program history
* ==========================================================================
* Author            Date            Version        History        code to fix
**/


package com.example.compass_aac.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import com.example.compass_aac.databinding.ActivityMainBinding
import com.example.compass_aac.view.dailyaac.DailyCategory
import com.example.compass_aac.view.favorite.FavoriteMain
import com.example.compass_aac.view.urgencyaac.UrgencyCategory
import com.example.compass_aac.view.location.SearchLocation
import com.example.compass_aac.view.login.TitleActivity
import com.example.compass_aac.view.user.UserPage
import com.example.compass_aac.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var backPressedTime: Long = 0

    private val viewModel: MainViewModel by viewModels()


    //뒤로 가기 두번 누르면 로그아웃되고 다시 로그인 하는 창으로 이동
//    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
//        override fun handleOnBackPressed() {
//            val currentTime = System.currentTimeMillis()
//            val intervalTime = currentTime - backPressedTime
//
//            if (intervalTime in 0..2000) {
//                val intent = Intent(this@MainActivity, ::class.java)
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//                startActivity(intent)
//            } else {
//                backPressedTime = currentTime
//                Toast.makeText(applicationContext, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback)


        //PASS AAC
        binding.mainPassBtn.setOnClickListener {
            val intent = Intent(this, SearchLocation::class.java)
            startActivity(intent)
        }

        //즐겨찾기
        binding.mainStarBtn.setOnClickListener {
            val intent = Intent(this, FavoriteMain::class.java)
            startActivity(intent)
        }
        //일상 AAC
//        binding.mainDailyBtn.setOnClickListener {
//            val intent = Intent(this, DailyCategory::class.java)
//            startActivity(intent)
//        }
        //긴급 AAC
        binding.mainUrgencyBtn.setOnClickListener {
            val intent = Intent(this, UrgencyCategory::class.java)
            startActivity(intent)
//            Toast.makeText(applicationContext, "기능 구현 중입니다.", Toast.LENGTH_SHORT).show()

        }

        //유저페이지
//        binding.mainUser.setOnClickListener {
//            val intent = Intent(this, UserPage::class.java)
//            startActivity(intent)
//        }
    }

}