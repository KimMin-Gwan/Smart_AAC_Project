package com.example.compass_aac.view.urgencyaac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compass_aac.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullSrceen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_srceen)
    }
}