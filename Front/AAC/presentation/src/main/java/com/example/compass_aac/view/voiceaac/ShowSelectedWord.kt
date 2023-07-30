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
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityChooseWordPassBinding
import com.example.compass_aac.databinding.ActivityShowSelectedWordBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class ShowSelectedWord : AppCompatActivity() , TextToSpeech.OnInitListener {

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val intent = Intent(this@ShowSelectedWord, ChooseWordPass::class.java)
            startActivity(intent)
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }

    private lateinit var textToSpeech: TextToSpeech

    // ViewBinding 객체 선언
    private lateinit var binding: ActivityShowSelectedWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowSelectedWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback) //위에서 생성한 콜백 인스턴스 붙여주기


        // TextToSpeech 객체 초기화
        textToSpeech = TextToSpeech(this, this)

        // 버튼 클릭 시 TTS 실행
        binding.ttsBtn.setOnClickListener {
            val textToRead = "안녕하세요, TTS 기능을 사용하고 있습니다."
            textToSpeech.speak(textToRead, TextToSpeech.QUEUE_FLUSH, null, null)
        }

        binding.ttsBtn1.setOnClickListener {
            val textToRead = "안녕하세요! 저는 언어장애인입니다. 저는 COMPASS [보완대체의사소통 앱]으로 효율적이고 빠른 의사소통을 합니다. 저에게 추가로 하고 싶은 말이 있으시면 아래 [대답하기]를 눌러주시면 음성인식이 됩니다. 친절히 응대해주셔서 감사합니다."
            textToSpeech.speak(textToRead, TextToSpeech.QUEUE_FLUSH, null, null)

        }
        binding.selectedWordAnswerBtn.setOnClickListener {
            val intent = Intent(this, HearVoice::class.java)
            startActivity(intent)
        }

        binding.selectWordBackBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
            Log.e("뒤로가기", "뒤로가기 클릭")

        }
    }

    override fun onInit(status: Int) {
        // TTS 초기화 성공 시
        if (status == TextToSpeech.SUCCESS) {
            // 언어 설정 (한국어로 설정)
            val result = textToSpeech.setLanguage(Locale.KOREAN)

            // 언어 데이터가 없거나 지원하지 않는 경우
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "한국어 TTS를 지원하지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "TTS 초기화에 실패했습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.stop()
        textToSpeech.shutdown()
    }
}