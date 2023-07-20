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
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.compass_aac.databinding.ActivitySearchLocationBinding
import com.example.compass_aac.viewmodels.LocationViewModel
import com.example.compass_aac.views.voiceaac.PassCategory


class SearchLocation : AppCompatActivity() {
    companion object {
        const val PERMISSIONS_REQUEST_CODE = 100
        val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    private lateinit var locationViewModel: LocationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 뷰 바인딩
        val binding = ActivitySearchLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 뷰모델 연결
        locationViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(LocationViewModel::class.java)

        //프로그래스바 업데이트
        locationViewModel.isLoading.observe(this, Observer { isLoading ->
            binding.progressBar.isIndeterminate= isLoading
        })

        // 위치 정보 성공적으로 가져오면 -> intent
        locationViewModel.locationResult.observe(this, Observer { result ->
            // 위치 정보를 가져오는 작업이 완료되면 실행됩니다.
            result.onSuccess { location ->
                // 위치 정보를 성공적으로 가져온 경우
                val intent = Intent(this, PassCategory::class.java)
                startActivity(intent)
            }.onFailure { e ->
                Toast.makeText(this, "위치 정보를 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
                // 위치 정보를 가져오는 데 실패한 경우 에러 처리
            }
        })


        // 권한 허용 -> 비동기로 위치 정보 불러오기, 허용 X -> 권한 요청
        if (checkPermissions()) {
            //위치 정보 가져오는 동안 프로그래스바 실행, 위치 정보 다 가져오면 placeCategory로 intent
            locationViewModel.fetchLocationAsync()

        } else {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, PERMISSIONS_REQUEST_CODE)
        }
    }

    // 위치 권한이 허용되었는지 확인 -> true, false
    private fun checkPermissions(): Boolean {
        for (permission in REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    // 위치 권한 요청 후 사용자의 응답을 처리하는 메서드
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
            // 모든 권한 허용됨 -> 위치 정보 가져오기
            if (checkResult) {
                //위치 정보 가져오는 동안 프로그래스바 실행, 위치 정보 다 가져오면 placeCategory로 intent
                locationViewModel.fetchLocationAsync()
            }
            // 권한 거부됨 -> 권한이 필요하다는 toast 메세지
            else {
                Toast.makeText(this, "Location permissions are necessary for the app to run", Toast.LENGTH_SHORT).show()
            }
        }
    }
}