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

package com.example.compass_aac.viewmodel.login

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Login
import com.example.domain.model.Loginrequest
import com.example.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val usecase: LoginUseCase):ViewModel() {

    //phone, pw 대한 LiveData 정의
    private val _userloginphone = MutableLiveData<String>()
    //UI에 변경된 값을 나타내줘야할 때 사용 (지금은 사용 x)
     val userLoginPhone: LiveData<String> = _userloginphone

    private val _userloginpw = MutableLiveData<String>()
     val userLoginPw: LiveData<String> = _userloginpw

    private val _loginresult = MutableLiveData<Result<Login>>()
     val loginresult : LiveData<Result<Login>> get() = _loginresult

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
        val login = Loginrequest(enteredUserphone!!,enteredPassword!!)

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                try {
                    val response = usecase.invoke(login)
                    Log.d("response", response.toString())
                    if(response.message=="login success"){
                        _loginresult.postValue(Result.success(response))
                    }
                    else{
                        _loginresult.postValue(Result.failure(Throwable("fail")))
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