/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 긴급 AAC 카테고리 선택화면
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.view.urgencyaac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compass_aac.databinding.ActivityUrgencyCategoryBinding

class UrgencyCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩
        val binding = ActivityUrgencyCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}