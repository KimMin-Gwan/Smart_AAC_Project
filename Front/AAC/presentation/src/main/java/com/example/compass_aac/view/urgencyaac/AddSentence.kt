package com.example.compass_aac.view.urgencyaac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compass_aac.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddSentence : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sentence)
    }
}