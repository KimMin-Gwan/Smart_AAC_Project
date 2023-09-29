package com.example.compass_aac.viewmodel.voiceaac

import android.app.Application
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.ShowSelectedWordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log


@HiltViewModel
class ShowSelectedWordVIewModel @Inject constructor(private val showSelectedWordUseCase: ShowSelectedWordUseCase, application: Application): AndroidViewModel(application) {

    private val tts: TextToSpeech by lazy {
        TextToSpeech(getApplication()) { status ->
            if (status == TextToSpeech.SUCCESS) {
                // TTS 엔진 초기화 성공
            } else {
                Log.e("TTS Error", "TTS engine initialization failed")
            }
        }
    }
    //선택한 단어들
    private val _textToRead = MutableLiveData<ArrayList<String>>()
    val textToRead :LiveData<ArrayList<String>> get() = _textToRead

    //커스터마이징한 문장
    private val _customizedText = MutableLiveData<String>()
    val customizedText : LiveData<String> get() = _customizedText

    //선택한 단어들 음성으로 말하기
    fun speakText() {
        viewModelScope.launch {
            val text=_textToRead.value
            val sentence = text?.joinToString(" ")
            showSelectedWordUseCase.speakText(sentence!!)
        }
    }

    //커스터마이즈한 문장 음성으로 말하기
    fun speakInf(){
        viewModelScope.launch {
            val textToRead = _customizedText.value ?: "안녕하세요! 저는 언어소통에 어려움이 있습니다. 저는 COMPASS앱을 통해 효율적이고 빠른 의사소통을 합니다. 저에게 추가로 하고 싶은 말이 있으시면, 아래 [대답하기]를 눌러주시면 음성인식이 됩니다. 친절히 응대해주셔서 감사합니다."
            showSelectedWordUseCase.speakText(textToRead)
        }
    }

    //음성 중지
    public override fun onCleared() {
        super.onCleared()
        showSelectedWordUseCase.stopSpeaking()
        showSelectedWordUseCase.shutdown()
    }

    //선택한 문장 가져오기
    fun getText(text : ArrayList<String>){
        val gettext = text.toString()
        Log.d("getText", gettext)
         _textToRead.value = text
    }

    //커스터마이즈 문장 가져오기
    fun getTextInf(text: String){
        _customizedText.value = text
    }

    fun resetData(){
        _textToRead.value = arrayListOf()
    }

//    fun loadData(){
//        _customizedText.postValue("안녕하세요!\n저는 언어소통에 어려움이 있습니다.\n저는 COMPASS앱을 통해\n효율적이고 빠른 의사소통을 합니다.\n저에게 추가로 하고 싶은 말이 있으시면\n아래 [대답하기]를 눌러주시면 음성인식이 됩니다.\n친절히 응대해주셔서 감사합니다.")
//    }

}