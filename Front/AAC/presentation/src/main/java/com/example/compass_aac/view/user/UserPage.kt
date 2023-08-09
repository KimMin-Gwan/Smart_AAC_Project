package com.example.compass_aac.view.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityUserPageBinding
import com.example.compass_aac.viewmodel.user.UserPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserPage: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUserPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.customizeBtn.setOnClickListener {
            val intent = Intent(this, Customizing::class.java)
            startActivity(intent)
        }



    }

}