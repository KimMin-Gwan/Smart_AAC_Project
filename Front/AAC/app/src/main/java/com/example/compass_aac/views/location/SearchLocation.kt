/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 위치 탐색하는 부분  (어디든 PASS 눌렀을 때 나오는 그 다음 화면)
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.views.location

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compass_aac.databinding.ActivitySearchLocationBinding

class SearchLocation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰 바인딩
        val binding = ActivitySearchLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}