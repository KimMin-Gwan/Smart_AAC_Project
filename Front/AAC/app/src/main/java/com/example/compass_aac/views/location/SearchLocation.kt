/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 위치 탐색하는 부분  (어디든 PASS 눌렀을 때 나오는 그 다음 화면)
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.views.location

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.compass_aac.databinding.ActivitySearchLocationBinding
import com.example.compass_aac.datas.ConvertGPS
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.suspendCoroutine


class SearchLocation : AppCompatActivity() {
    companion object {
        const val PERMISSIONS_REQUEST_CODE = 100
        val REQUIRED_PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰 바인딩
        val binding = ActivitySearchLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        if (checkPermissions()) {
            fetchLocationAsync()
        } else {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, PERMISSIONS_REQUEST_CODE)
        }

    }
    private fun checkPermissions(): Boolean {
        for (permission in REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    private fun fetchLocationAsync() = scope.launch {
        val location = getLastKnownLocation()
        location?.let {
            Log.d("Location", "Latitude: ${location.latitude}, Longitude: ${location.longitude}")
            val XY= ConvertGPS(0, location.latitude, location.longitude)
            Log.d("좌표 값", "${XY.x}, ${XY.y}")
        }
    }

    private suspend fun getLastKnownLocation(): Location? = suspendCoroutine { continuation ->
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return@suspendCoroutine
        }
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            continuation.resumeWith(Result.success(location))
        }.addOnFailureListener { e ->
            continuation.resumeWith(Result.failure(e))
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSIONS_REQUEST_CODE && grantResults.size == REQUIRED_PERMISSIONS.size) {
            var checkResult = true
            for (result in grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    checkResult = false
                    break
                }
            }

            if (checkResult) {
                fetchLocationAsync()
            } else {
                Toast.makeText(this, "Location permissions are necessary for the app to run", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
