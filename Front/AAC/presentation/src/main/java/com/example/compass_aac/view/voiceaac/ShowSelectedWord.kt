/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - aac 단어들 선택 후 문장으로 보여지는 화면
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
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityChooseWordPassBinding
import com.example.compass_aac.databinding.ActivityShowSelectedWordBinding
import com.example.compass_aac.view.MainActivity
import com.example.compass_aac.viewmodel.voiceaac.HearVoiceViewModel
import com.example.compass_aac.viewmodel.voiceaac.ShowSelectedWordVIewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class ShowSelectedWord @Inject constructor(): AppCompatActivity() {
    //근데 선택된 단어들이 없는 경우 stt 가져오는거 에러날거임 (아무 버튼도 선택안했을 시의 오류처리도 해야함, 못넘어가게 한다던가...)

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val intent = Intent(this@ShowSelectedWord, ChooseWordPass::class.java)
            startActivity(intent)
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }


    // ViewBinding 객체 선언
    private lateinit var binding: ActivityShowSelectedWordBinding


    private val viewModel: ShowSelectedWordVIewModel by viewModels() // ViewModel 인스턴스 주입


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowSelectedWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback) //위에서 생성한 콜백 인스턴스 붙여주기

        val text = "안녕하세요, TTS 기능을 사용하고 있습니다."
        viewModel.getText(text)

        // 버튼 클릭 시 TTS 실행
        binding.ttsBtn.setOnClickListener {
            viewModel.speakText()
        }

        binding.ttsBtn1.setOnClickListener {
            viewModel.speakInf()

        }

        viewModel.textToRead.observe(this){text ->
            binding.selectedWordShowTv.text= text
        }

        binding.selectedWordAnswerBtn.setOnClickListener {
            val intent = Intent(this, HearVoice::class.java)
            startActivity(intent)
            viewModel.onCleared()
        }

        binding.selectedWordOkBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            viewModel.resetData()
            viewModel.onCleared()
        }

        binding.selectWordBackBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
            Log.e("뒤로가기", "뒤로가기 클릭")

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onCleared()

    }
}