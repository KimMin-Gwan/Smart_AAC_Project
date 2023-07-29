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


package com.example.compass_aac.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.LoginUseCase
import com.example.domain.usecase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val usecase: RegisterUseCase) :ViewModel(){

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

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                try {
                    val response = usecase.invoke(registername,registerphone,registerpw)
                    Log.d("response", response.toString())
                }
                catch (e:Exception){
                    Log.d(TAG, e.message.toString())

                }
            }

        }
    }
}