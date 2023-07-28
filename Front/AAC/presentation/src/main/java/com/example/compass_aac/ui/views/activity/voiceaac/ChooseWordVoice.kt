/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 음성인식에 따른 aac 선택하는 화면
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/
package com.example.compass_aac.ui.views.activity.voiceaac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.compass_aac.databinding.ActivityChooseWordVoiceBinding

class ChooseWordVoice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩
        val binding = ActivityChooseWordVoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val voicetext = intent.getStringExtra("voiceText")
        binding.voiceText.text = voicetext
        Log.d("voiceText", voicetext!! )


        binding.selectWordBackBtn.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}