package com.example.data.source.remote

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import com.google.android.gms.location.LocationRequest
import androidx.core.app.ActivityCompat
import com.example.data.model.remote.CategoryResponse
import com.example.data.api.LocationApiService
import com.example.data.mapper.MapperToLocation
import com.example.data.mapper.MapperToLogin
import com.example.domain.model.LocationParam
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LocationDataSourceImpl @Inject constructor(private val locationApiService : LocationApiService, private val fusedLocationClient: FusedLocationProviderClient, @ActivityContext private val context: Context) : LocationDataSource {
    override suspend fun getLocation() = getLastKnownLocation()

    override suspend fun getCategories(param:LocationParam): CategoryResponse {
        val mapper = MapperToLocation(param)
        return locationApiService.locationXY(mapper)
    }

    private suspend fun getLastKnownLocation(): Result<Location?> = suspendCancellableCoroutine { continuation ->
        //위치 정보 업데이트에 대한 요청
        val locationRequest = LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY //가장 높은 정확도를 가진 위치 업데이트를 요청, GPS와 Wi-Fi를 사용
            //한 번의 위치 업데이트만 요청
            numUpdates = 1
        }

        //권한 부여 안된경우, 예외 발생 시킴
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            continuation.resume(Result.failure(Exception("Location Permission Denied")))
        } else {
            //위치 정보를 얻기 위한 콜백 객체인 locationCallback을 정의
            //onLocationResult 함수가 위치 결과를 처리하고 코루틴을 완료
            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(p0: LocationResult) {
                    continuation.resume(Result.success(p0.lastLocation))  //resume : 일시 중지했던 코루틴을 다시 꺠우는 메소드
                    fusedLocationClient.removeLocationUpdates(this) //콜백 제거
                }
            }
            //fusedLocationClient를 사용하여 위치 업데이트
            //locationRequest는 위치 정보 요청을 설정하고, locationCallback은 위치 정보 결과를 처리
            //Looper.getMainLooper()는 메인 스레드에서 위치 업데이트
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())

            //코루틴이 취소될 때 (예를 들어, 코루틴이 실행 중에 사용자가 해당 화면을 떠나거나 취소될 때)
            //invokeOnCancellation 함수를 사용하여 위치 업데이트를 중지하고 콜백을 제거합니다.
            continuation.invokeOnCancellation {
                fusedLocationClient.removeLocationUpdates(locationCallback)
            }
        }
    }

}