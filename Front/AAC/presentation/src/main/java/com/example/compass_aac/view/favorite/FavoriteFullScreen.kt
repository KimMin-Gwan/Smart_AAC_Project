package com.example.compass_aac.view.favorite

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        binding.favoriteSentence.text = selectedSentence

        binding.favoriteClose.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
            finish()

        }
    }
}