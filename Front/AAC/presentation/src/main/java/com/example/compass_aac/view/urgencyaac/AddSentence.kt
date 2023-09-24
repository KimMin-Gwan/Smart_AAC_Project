package com.example.compass_aac.view.urgencyaac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityAddSentenceBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddSentence : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAddSentenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButton4.setOnClickListener {
        }
    }
}