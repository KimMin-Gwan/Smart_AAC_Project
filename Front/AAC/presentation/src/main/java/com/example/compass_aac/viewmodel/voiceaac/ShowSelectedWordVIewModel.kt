package com.example.compass_aac.viewmodel.voiceaac

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.ShowSelectedWordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ShowSelectedWordVIewModel @Inject constructor(private val showSelectedWordUseCase: ShowSelectedWordUseCase, application: Application): AndroidViewModel(application) {

    private val _textToRead = MutableLiveData<String>()
    val textToRead :LiveData<String> get() = _textToRead

    fun speakText() {
        viewModelScope.launch {
            val text=_textToRead.value
            showSelectedWordUseCase.speakText(text!!)
        }
    }

    fun speakInf(){
        viewModelScope.launch {
            val textToRead = "안녕하세요! 저는 언어장애인입니다. 저는 COMPASS [보완대체의사소통 앱]으로 효율적이고 빠른 의사소통을 합니다. 저에게 추가로 하고 싶은 말이 있으시면 아래 [대답하기]를 눌러주시면 음성인식이 됩니다. 친절히 응대해주셔서 감사합니다."
            showSelectedWordUseCase.speakText(textToRead)
        }
    }

    public override fun onCleared() {
        super.onCleared()
        showSelectedWordUseCase.stopSpeaking()
        showSelectedWordUseCase.shutdown()
    }


    fun getText(text : String){
        viewModelScope.launch(Dispatchers.IO) {
//            _textToRead.postValue("안녕하세요, TTS 기능을 사용하고 있습니다.")
            _textToRead.postValue(text)

        }
    }

    fun resetData(){
        _textToRead.value = ""
    }

}