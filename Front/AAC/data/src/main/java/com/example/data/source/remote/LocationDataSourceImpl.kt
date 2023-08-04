package com.example.data.source.remote

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
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
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LocationDataSourceImpl @Inject constructor(
    private val locationApiService : LocationApiService,
    private val fusedLocationClient: FusedLocationProviderClient,
    @ApplicationContext private val context: Context
) : LocationDataSource {
    override suspend fun getLocation() = getLastKnownLocation()
    override suspend fun getCategories(param:LocationParam): CategoryResponse {
        val mapper = MapperToLocation(param)
        return locationApiService.locationXY(mapper)
    }


    private suspend fun getLastKnownLocation(): Result<Location?> = suspendCoroutine { continuation ->
        val locationRequest = LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            numUpdates = 1
        }

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            continuation.resume(Result.failure(Exception("Location Permission Denied")))
        } else {
            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(p0: LocationResult) {
                    continuation.resume(Result.success(p0.lastLocation))
                    fusedLocationClient.removeLocationUpdates(this)
                }
            }
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
        }
    }
}