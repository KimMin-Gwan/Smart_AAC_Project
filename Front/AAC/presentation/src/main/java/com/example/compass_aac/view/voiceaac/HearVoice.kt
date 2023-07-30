/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 음성 듣는 화면
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.view.voiceaac

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.compass_aac.databinding.ActivityHearVoiceBinding
import com.example.compass_aac.viewmodel.HearVoiceViewModel
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class HearVoice : AppCompatActivity() {

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val intent= Intent(this@HearVoice, ShowSelectedWord::class.java)
            startActivity(intent)
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }

    private lateinit var speechRecognizer: SpeechRecognizer
    private lateinit var recognitionListener: RecognitionListener
    private val viewModel: HearVoiceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHearVoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //viewmodel 생성
//        viewModel = ViewModelProvider(this).get(HearVoiceViewModel::class.java)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback) //위에서 생성한 콜백 인스턴스 붙여주기


        // 음성인식 후 텍스트보여지는 livedata 관찰
        viewModel.recognizedSpeechText.observe(this, Observer { text ->
            binding.voiceToTextTv.text = text
            binding.hearVoiceEndBtn.setOnClickListener {
                val intent = Intent(this@HearVoice, ChooseWordVoice::class.java)
                intent.putExtra("voiceText", text)
                startActivity(intent)
            }
        })
        //음성인식 완료 후 음성 인식 완료 버튼을 수명주기에 맞게 보존
        viewModel.isEndOfSpeech.observe(this, Observer { isEndOfSpeech ->
            binding.hearVoiceEndBtn.isVisible = isEndOfSpeech
        })

        //음성인식 권한 허용
        requestPermission()

        var intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, packageName)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR")

        //음성인식 전,중,후에 관한 처리 메소드
        setListener()

        //음성인식 버튼 누르면 음성인식 활성화
        binding.hearVoiceBtn.setOnClickListener {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
            speechRecognizer.setRecognitionListener(recognitionListener)
            speechRecognizer.startListening(intent)
        }

        binding.hearVoiceBackBtn.setOnClickListener {
            viewModel.resetData()
            onBackPressedDispatcher.onBackPressed()

        }
    }

    override fun onBackPressed() {
        viewModel.resetData()
        super.onBackPressed()
    }


    private fun requestPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            // 거부해도 계속 노출됨. ("다시 묻지 않음" 체크 시 노출 안됨.)
            // 허용은 한 번만 승인되면 그 다음부터 자동으로 허용됨.
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.RECORD_AUDIO), 0)
        }
    }


    private fun setListener() {
        recognitionListener = object: RecognitionListener {

            override fun onReadyForSpeech(params: Bundle?) {
                Toast.makeText(applicationContext, "음성인식을 시작합니다.", Toast.LENGTH_SHORT).show()
            }
            override fun onBeginningOfSpeech() {

            }
            override fun onRmsChanged(rmsdB: Float) {

            }
            override fun onBufferReceived(buffer: ByteArray?) {

            }
            override fun onEndOfSpeech() {
                viewModel.setEndOfSpeech(true)
            }
            override fun onError(error: Int) {
                var message: String
                when (error) {
                    SpeechRecognizer.ERROR_AUDIO ->
                        message = "오디오 에러"
                    SpeechRecognizer.ERROR_CLIENT ->
                        message = "클라이언트 에러"
                    SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS ->
                        message = "퍼미션 없음"
                    SpeechRecognizer.ERROR_NETWORK ->
                        message = "네트워크 에러"
                    SpeechRecognizer.ERROR_NETWORK_TIMEOUT ->
                        message = "네트워크 타임아웃"
                    SpeechRecognizer.ERROR_NO_MATCH ->
                        message = "찾을 수 없음"
                    SpeechRecognizer.ERROR_RECOGNIZER_BUSY ->
                        message = "RECOGNIZER가 바쁨"
                    SpeechRecognizer.ERROR_SERVER ->
                        message = "서버가 이상함"
                    SpeechRecognizer.ERROR_SPEECH_TIMEOUT ->
                        message = "말하는 시간초과"
                    else ->
                        message = "알 수 없는 오류"
                }
                Toast.makeText(applicationContext, "에러 발생 $message", Toast.LENGTH_SHORT).show()
            }

            //음성인식 한 결과
            override fun onResults(results: Bundle?) {
                var matches: ArrayList<String> = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) as ArrayList<String>
                Log.d("음성 텍스트로 변환", matches.toString())

                for (i in 0 until matches.size) {
                    viewModel.updateRecognizedSpeechText(matches[i])
                }
            }

            override fun onPartialResults(partialResults: Bundle?) {

            }

            override fun onEvent(eventType: Int, params: Bundle?) {

            }

        }
    }

}