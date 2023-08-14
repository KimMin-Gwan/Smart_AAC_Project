/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 로그인, 회원가입 페이지(스플래쉬 화면 다음)
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/


package com.example.compass_aac.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compass_aac.databinding.ActivityTitleBinding
import com.example.compass_aac.view.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TitleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTitleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //로그인 눌렀을 때
        binding.titleLoginBtn.setOnClickListener {
            val intent = Intent(this, LoginMain::class.java)
            startActivity(intent)

        }
        //회원가입 눌렀을 때
        binding.titleUnloginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}