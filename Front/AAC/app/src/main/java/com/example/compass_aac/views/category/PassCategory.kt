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


package com.example.compass_aac.views.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compass_aac.databinding.ActivityPassCategoryBinding

class PassCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩
        val binding = ActivityPassCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}