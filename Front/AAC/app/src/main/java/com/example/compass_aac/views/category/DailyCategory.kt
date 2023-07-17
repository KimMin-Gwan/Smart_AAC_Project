/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 일상 AAC 카테고리 선택화면
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
import com.example.compass_aac.databinding.ActivityDailyCategoryBinding

class DailyCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰 바인딩
        val binding = ActivityDailyCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}