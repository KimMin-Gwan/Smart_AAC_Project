/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 회원가입 Viewmodel 처리 (데이터 처리에 관한건 여기서)
 * ex) coroutine, livedata, mutablelivedata . . .
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/


package com.example.compass_aac.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compass_aac.apis.UserRegisterApiService
import com.example.compass_aac.apis.UserRegisterService
import com.example.compass_aac.apis.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel :ViewModel(){

    private val _userName = MutableLiveData<String>()
    private val userName: LiveData<String> = _userName

    private val _userPhone = MutableLiveData<String>()
    private val userPhone: LiveData<String> = _userPhone

    private val _userPassword = MutableLiveData<String>()
    private val userPassword: LiveData<String> = _userPassword

    fun updateUserName(name: String) {
        _userName.value = name
    }

    fun updateUserPhone(phone: String) {
        _userPhone.value = phone
    }

    fun updateUserPassword(password: String) {
        _userPassword.value = password
    }

    fun registerUser() {
        val registername = userName.value!!
        val registerphone = userPhone.value!!
        val registerpw = userPassword.value!!
        Log.d("register", "${registername}, ${registerphone}, $registerpw")

//        val apiService = UserRegisterService().provideUserRegisterApiService()

        // 회원 가입을 위한 서버 통신 등의 작업 수행
//        viewModelScope.launch {
//            withContext(Dispatchers.IO){
//                try {
//                    val response = apiService.registerUser(registername,registerphone,registerpw)
//                    if (response.isSuccessful) {
//                        // handle successful response
//                        val registrationResponse = response.body()
//                        // use 'registrationResponse'
//                    } else {
//                        // handle error response
//                    }
//                } catch (e: Exception) {
//                    Log.d("error", "${e.message}")
//                    // handle network error
//                }
//            }
//        }
    }
}