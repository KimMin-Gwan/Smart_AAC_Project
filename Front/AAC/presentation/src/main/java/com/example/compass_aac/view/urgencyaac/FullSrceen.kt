package com.example.compass_aac.view.urgencyaac

import android.content.ContentValues
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityFullSrceenBinding
import com.example.compass_aac.viewmodel.favorite.FavoriteVoiceViewModel
import com.example.compass_aac.viewmodel.urgencyaac.FullScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullSrceen : AppCompatActivity() {

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            viewModel.stopSentence()
            viewModel.shutdownSentence()
            finish()
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }
    private val viewModel : FullScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //가로모드
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

        val binding = ActivityFullSrceenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback) //위에서 생성한 콜백 인스턴스 붙여주기

        val urgencySentence = intent.getStringExtra("urgencySentence") ?: "default"

        viewModel.storeSentence(urgencySentence)

        binding.UrgencySentence.text = urgencySentence
        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.translate_alpha)
        binding.UrgencySentence.animation = anim
        binding.UrgencySentence.startAnimation(anim)

        binding.UrgencyVoice.setOnClickListener {
            viewModel.speakSentence()
        }

        binding.urgencyClose.setOnClickListener {
            viewModel.speakSentence()
            viewModel.shutdownSentence()
            finish()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.shutdownSentence()
    }

}