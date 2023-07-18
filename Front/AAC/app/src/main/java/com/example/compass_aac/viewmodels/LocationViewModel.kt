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
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compass_aac.datas.ConvertGPS
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LocationViewModel(application: Application) : AndroidViewModel(application) {
    val locationData = MutableLiveData<Location?>()

    private val fusedLocationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(application)
    }

    fun fetchLocationAsync() = viewModelScope.launch {
        val location = getLastKnownLocation()
        location?.let {
            Log.d("Location", "Latitude: ${location.latitude}, Longitude: ${location.longitude}")
            val XY = ConvertGPS(0, location.latitude, location.longitude)
            Log.d("좌표 값", "${XY.x}, ${XY.y}")
        }
    }

    private suspend fun getLastKnownLocation(): Location? = suspendCoroutine { continuation ->
        val context = getApplication<Application>().applicationContext
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            continuation.resume(null)
        } else {
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                continuation.resumeWith(Result.success(location))
            }.addOnFailureListener { e ->
                continuation.resumeWith(Result.failure(e))
            }
        }
    }
}