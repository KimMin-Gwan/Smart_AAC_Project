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


package com.example.compass_aac.viewmodel.login

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Register
import com.example.domain.usecase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val usecase: RegisterUseCase) :ViewModel(){

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _userPhone = MutableLiveData<String>()
    val userPhone: LiveData<String> = _userPhone

    private val _userPassword = MutableLiveData<String>()
    val userPassword: LiveData<String> = _userPassword

    private val _registerResult = MutableLiveData<Result<List<Register>>>()
    val registerResult :LiveData<Result<List<Register>>> get() = _registerResult


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
        val registername = _userName.value!!
        val registerphone = _userPhone.value!!
        val registerpw = _userPassword.value!!
        Log.d("register", "${registername}, ${registerphone}, $registerpw")

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                try {
                    val response = usecase.invoke(registername,registerphone,registerpw)
                    if (response.isNotEmpty()){
                        _registerResult.postValue(Result.success(response))
                        Log.d("response", response.toString())
                    }
                    else{
                        _registerResult.postValue(Result.failure(Throwable("fail")))
                    }

                }
                catch (e:Exception){
                    Log.d(TAG, e.message.toString())

                }
            }

        }
    }
}