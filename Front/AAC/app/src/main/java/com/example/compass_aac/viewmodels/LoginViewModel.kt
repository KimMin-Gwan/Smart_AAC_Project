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

package com.example.compass_aac.viewmodels

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compass_aac.datas.apis.UserRegisterService
import com.example.compass_aac.datas.apis.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel:ViewModel() {

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

//        val apiService = UserService().provideUserApiService()

        //phone 형식 숫자로 변환해야하면 변환하기
//        viewModelScope.launch {
//            withContext(Dispatchers.IO){
//                //서버 통신하여 유저가 맞는지 확인 -> 맞는 경우 메인 화면으로 intent / 아닌 경우 Toast로 로그인 값이 틀렸다는 메시지 출력
//                try {
//                    val response= apiService.loginUser(enteredUsername!!, enteredPassword!!)
//                    if (response.isSuccessful) {
//                        Log.d("success", "$response")
//                        // 응답값 불러오기
//                    } else {
//                        // 응답 실패 에러
//                        Log.d("fail", "$response")
//                    }
//
//                }catch (e:Exception){
//                    Log.d(TAG, "${e.message}")
//                }
//
//            }
//        }
    }
}