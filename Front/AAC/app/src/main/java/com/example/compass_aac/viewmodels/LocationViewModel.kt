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

package com.example.compass_aac.viewmodels

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compass_aac.apis.LocationService
import com.example.compass_aac.datas.ConvertGPS
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LocationViewModel(application: Application) : AndroidViewModel(application) {

    //프로그래스바 제어
    val isLoading = MutableLiveData<Boolean>()

    //위치 받기 성공 -> view에서 PassCategory로 intent 해줌
//    val locationResult = MutableLiveData<Result<Location?>>()

    val categoryResult = MutableLiveData<Result<String>>()

    private val fusedLocationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(application)
    }
    fun fetchLocationAsync() = viewModelScope.launch {
        isLoading.postValue(true)
        try {
            val location = getLastKnownLocation()
            Log.d("location", location.toString())

            location?.let {
                Log.d("Location", "Latitude: ${location.latitude}, Longitude: ${location.longitude}")
                val XY = ConvertGPS(0, location.latitude, location.longitude)
                Log.d("좌표 값", "${XY.x}, ${XY.y}")

                // LocationService를 이용해 LocationApiService 인스턴스 생성
                val service = LocationService().providelocationApiService()
                // Send the location to server
                val response = service.locationXY(XY.x, XY.y)

                if (response.isSuccessful && response.body() != null) {
                    // response 응답 값
                    val category = response.body()!!.category
                    // 받아온 카테고리 값 LiveData 저장
                    categoryResult.postValue(Result.success(category))

                } else {
                    // 레트로핏 통신 에러
                    categoryResult.postValue(Result.failure(RuntimeException("Response not successful or body is null")))
                }

                delay(2000)
                isLoading.postValue(false)
//                locationResult.postValue(Result.success(location)) // 결과를 LiveData에 저장
            }
        } catch (e: Exception) {
//            locationResult.postValue(Result.failure(e)) // 실패한 경우 에러를 LiveData에 저장
            Log.e("LocationViewModel", "Error fetching location", e)
        } finally {
            delay(2000)
            isLoading.postValue(false)
        }
    }

    private suspend fun getLastKnownLocation(): Location? = suspendCoroutine { continuation ->
        val locationRequest = LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            numUpdates = 1
        }

        val context = getApplication<Application>().applicationContext
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            continuation.resume(null)
        } else {
            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(p0: LocationResult) {
                    continuation.resume(p0.lastLocation)
                    fusedLocationClient.removeLocationUpdates(this)
                }
            }
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
        }
    }
}