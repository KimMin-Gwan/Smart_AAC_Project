/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 스플래쉬 화면 (처음 나왔다 사라지는 앱 로고 화면)
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.compass_aac.databinding.ActivitySplashBinding
import com.example.compass_aac.view.MainActivity


class Splash : AppCompatActivity() {

    // Splash 화면을 보여주는 시간 (2초)
    private val SPLASH_TIME_OUT = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handler를 사용하여 일정 시간 후에 메인 화면으로 이동
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Splash 화면을 닫음
        }, SPLASH_TIME_OUT)


    }
}