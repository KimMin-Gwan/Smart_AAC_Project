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


package com.example.compass_aac.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compass_aac.databinding.ActivityMainBinding
import com.example.compass_aac.views.dailyaac.DailyCategory
import com.example.compass_aac.views.urgencyaac.UrgencyCategory
import com.example.compass_aac.views.location.SearchLocation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //PASS AAC
        binding.mainPassBtn.setOnClickListener {
            val intent = Intent(this, SearchLocation::class.java)
            startActivity(intent)
        }
        //일상 AAC
        binding.mainDailyBtn.setOnClickListener {
            val intent = Intent(this, DailyCategory::class.java)
            startActivity(intent)
        }
        //긴급 AAC
        binding.mainUrgencyBtn.setOnClickListener {
            val intent = Intent(this, UrgencyCategory::class.java)
            startActivity(intent)
        }


    }
}