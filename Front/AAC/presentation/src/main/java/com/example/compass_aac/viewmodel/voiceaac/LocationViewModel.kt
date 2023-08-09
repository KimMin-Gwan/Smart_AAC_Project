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

package com.example.compass_aac.viewmodel.voiceaac

import android.app.Application
import android.location.Location
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.compass_aac.view.ConvertGPS
import com.example.domain.model.Categories
import com.example.domain.model.LocationParam
import com.example.domain.usecase.LocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LocationViewModel @Inject constructor(private val usecase : LocationUseCase, application: Application)  : AndroidViewModel(application) {

    //프로그래스바 제어
    val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> get() = _isLoading
    //카테고리 값
    val _categoryResult = MutableLiveData<Result<Categories>>()
    val categoryResult : LiveData<Result<Categories>> get() = _categoryResult

    fun fetchLocationAsync() = viewModelScope.launch {
        _isLoading.postValue(true)

        try {
            val result = usecase.execute()
            Log.d("location", result.toString())
            val location: Location? = result.getOrNull()

            Log.d("location", location.toString())

            location?.let {
                val latitude = it.latitude
                val longitude = it.longitude
                Log.d("Location", "Latitude: ${latitude}, Longitude: ${longitude}")
                val XY = ConvertGPS(0, location.latitude, location.longitude)
                Log.d("좌표 값", "${XY.x}, ${XY.y}")
                val locationRequest = LocationParam(latitude,longitude)
                val categoryresult = usecase.getCategories(locationRequest)
                _categoryResult.postValue(Result.success(categoryresult))

                Log.d("categoryresult", categoryresult.toString())




                //x,y좌표값 서버에 전송 후 카테고리 응답값 받기


                //받아온 카테고리 값 livedata에 저장


                } ?: run {
                    Log.d("hi", "hi")
                // location이 null인 경우 실행될 코드를 여기에 작성
            }
            delay(3000)
            _isLoading.postValue(false)

            } catch (e: Exception) {
            Log.e("LocationViewModel", "Error fetching location", e)
        } finally {
            delay(2000)
            _isLoading.postValue(false)
        }
        return@launch
    }
}