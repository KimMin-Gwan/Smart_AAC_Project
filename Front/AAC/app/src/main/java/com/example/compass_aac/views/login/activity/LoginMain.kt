/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 로그인 메인 화면
 * - edittext 관하여 처리, 로그인 관련 Viewmodel 연결, 카카오톡 간편 로그인 연결 , 회원가입 , ID|PW 찾기
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.views.login.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.compass_aac.views.MainActivity
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityLoginMainBinding
import com.example.compass_aac.viewmodels.LoginViewModel

class LoginMain : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

//        binding.loginBtn.isEnabled= false

        //전화번호 edittext 처리
        binding.loginPhoneEdt.addTextChangedListener { editable ->
            editable?.let {
                viewModel.updateUserLoginPhone(it.toString())
            }
        }

        //비밀번호 edittext 처리
        binding.loginPwEdt.addTextChangedListener { editable ->
            editable?.let {
                viewModel.updateUserLoginPassword(it.toString())
            }
        }


        //로그인 버튼 눌렀을 때
        binding.loginBtn.setOnClickListener {
            viewModel.CheckLogin()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //뒤로가기
        binding.loginBackBtn.setOnClickListener {
            onBackPressed()
        }

    }
    // EditText 입력 상태를 확인하여 로그인 버튼 상태 업데이트
    fun checkLoginButtonStatus() {
        val loginPhoneEdt = findViewById<EditText>(R.id.login_phone_edt)
        val loginPwEdt = findViewById<EditText>(R.id.login_pw_edt)
        val loginBtn = findViewById<Button>(R.id.login_btn)
        val phone = loginPhoneEdt.text.toString().trim()
        val password = loginPwEdt.text.toString().trim()

        // 모든 EditText가 비어있지 않은 경우 로그인 버튼 활성화
        loginBtn.isEnabled = phone.isNotEmpty() && password.isNotEmpty()

    }

}