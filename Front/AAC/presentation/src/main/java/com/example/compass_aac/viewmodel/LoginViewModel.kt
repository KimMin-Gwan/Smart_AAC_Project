/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 로그인 Viewmodel 처리 (데이터 처리에 관한건 여기서)
 * ex) coroutine
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.viewmodel

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val usecase: LoginUseCase):ViewModel() {

    //phone, pw 대한 LiveData 정의
    val _userloginphone = MutableLiveData<String>()
    val userLoginPhone: LiveData<String> = _userloginphone
    val _userloginpw = MutableLiveData<String>()
    val userLoginPw: LiveData<String> = _userloginpw

    fun updateUserLoginPhone(phone: String) {
        _userloginphone.value = phone
    }

    fun updateUserLoginPassword(password: String) {
        _userloginpw.value = password
    }


    fun CheckLogin(){
        val enteredUserphone = _userloginphone.value
        val enteredPassword = _userloginpw.value
        Log.d("entered", "${enteredUserphone}, $enteredPassword")

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                try {
                    val response = usecase.invoke(enteredUserphone!!,enteredPassword!!)
                    Log.d("response", response.toString())

                    if (response[0].message == "success"){

                    }
                    else{

                    }
                }
                catch (e :Exception)
                {
                    Log.d(TAG, e.message.toString())
                }


            }
        }
    }
}