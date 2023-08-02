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
package com.example.compass_aac.view.voiceaac

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import com.example.compass_aac.databinding.ActivityChooseWordVoiceBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ChooseWordVoice : AppCompatActivity() {


    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val intent = Intent(this@ChooseWordVoice, HearVoice::class.java)
            startActivity(intent)
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩
        val binding = ActivityChooseWordVoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback)


        val voicetext = intent.getStringExtra("voiceText")
        binding.voiceText.text = "\"${voicetext}\""
        Log.d("voiceText", voicetext!! )


        binding.selectWordVoiceBackBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.selectedWordVoiceBtn.setOnClickListener {
            val intent = Intent(this, ShowSelectedWord::class.java)
            startActivity(intent)

        }
    }

}