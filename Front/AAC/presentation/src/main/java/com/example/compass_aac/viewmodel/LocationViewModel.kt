/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - SearchLocation.kt에서 위치 권한 허용을 받아와 viewmodel에서 위치 정보 찾기
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.viewmodel

import android.app.Application
import android.location.Location
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetLocationUseCase

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationViewModel @Inject constructor(private val usecase : GetLocationUseCase, application: Application)  : AndroidViewModel(application) {
    //위치 받기 성공 -> view에서 PassCategory로 intent 해줌
//    val locationResult = MutableLiveData<Result<Location?>>()
    //프로그래스바 제어
    val isLoading = MutableLiveData<Boolean>()
    val categoryResult = MutableLiveData<Result<String>>()
    val locationResult = MutableLiveData<Result<Location?>>()

    fun fetchLocationAsync() = viewModelScope.launch {
        isLoading.postValue(true)
        try {
            val result = usecase.execute()
            locationResult.postValue(result)

        } catch (e: Exception) {
//            locationResult.postValue(Result.failure(e)) // 실패한 경우 에러를 LiveData에 저장
            Log.e("LocationViewModel", "Error fetching location", e)
        } finally {
            delay(2000)
            isLoading.postValue(false)
        }
    }

}