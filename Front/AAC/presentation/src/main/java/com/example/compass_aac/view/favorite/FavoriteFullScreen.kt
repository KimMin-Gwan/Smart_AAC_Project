package com.example.compass_aac.view.favorite

import android.animation.ObjectAnimator
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.animation.LinearInterpolator
import androidx.activity.OnBackPressedCallback
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityFavoriteFullScreenBinding
import com.example.compass_aac.view.voiceaac.ShowSelectedWord

class FavoriteFullScreen : AppCompatActivity() {

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val intent= Intent(this@FavoriteFullScreen, FavoriteMain::class.java)
            startActivity(intent)
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivityFavoriteFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback) //위에서 생성한 콜백 인스턴스 붙여주기


        val selectedSentence = intent.getStringExtra("selectedSentence") ?: "default"

//        binding.favoriteSentence.text = selectedSentence
        binding.favoriteSentence.isSelected = true


        // 화면 크기 정보 가져오기
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenWidth = displayMetrics.widthPixels
        val screenHeight = displayMetrics.heightPixels

        // 원하는 가로 및 세로 비율 설정
        val desiredWidthRatio = 0.9 // 가로 80%
        val desiredHeightRatio = 0.8 // 세로 60%

        val newTextSize = when {
            screenWidth * desiredHeightRatio < screenHeight * desiredWidthRatio -> {
                // 세로 비율에 맞게 크기 조절
                (screenWidth * desiredHeightRatio / selectedSentence.length).toFloat()
            }
            else -> {
                // 가로 비율에 맞게 크기 조절
                (screenHeight * desiredWidthRatio / selectedSentence.length).toFloat()
            }
        }

        binding.favoriteSentence.textSize = newTextSize
        binding.favoriteSentence.text = selectedSentence


        binding.favoriteClose.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
            finish()

        }
    }
}