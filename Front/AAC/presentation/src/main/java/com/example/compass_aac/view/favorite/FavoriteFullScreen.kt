package com.example.compass_aac.view.favorite

import android.R
import android.content.ContentValues
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.compass_aac.databinding.ActivityFavoriteFullScreenBinding
import com.example.compass_aac.viewmodel.favorite.FavoriteVoiceViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteFullScreen @Inject constructor(): AppCompatActivity() {

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
//            val intent= Intent(this@FavoriteFullScreen, FavoriteMain::class.java)
//            startActivity(intent)
            viewModel.stopSentence()
            viewModel.shutdownSentence()
            finish()
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }

    private val viewModel : FavoriteVoiceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //가로모드
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

        val binding= ActivityFavoriteFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback) //위에서 생성한 콜백 인스턴스 붙여주기


        val selectedSentence = intent.getStringExtra("selectedSentence") ?: "default"
        //뷰모델에 선택된 문장 저장
        viewModel.storeSentence(selectedSentence)

        binding.favoriteSentence.text = selectedSentence

        val anim: Animation = AnimationUtils.loadAnimation(this, com.example.compass_aac.R.anim.translate_alpha)
        binding.favoriteSentence.animation = anim
        binding.favoriteSentence.startAnimation(anim)

        binding.favoriteVoice.setOnClickListener {
            viewModel.speakSentence()
        }

        binding.favoriteClose.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
            viewModel.shutdownSentence()
            finish()

        }



    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.shutdownSentence()
    }

    override fun onPause() {
        super.onPause()
        Log.d("pause", "pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("stop", "stop")
    }
}