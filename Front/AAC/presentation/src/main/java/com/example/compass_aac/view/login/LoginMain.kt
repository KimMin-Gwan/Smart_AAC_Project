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

package com.example.compass_aac.view.login

import android.content.ContentValues
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.example.compass_aac.view.MainActivity
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityLoginMainBinding
import com.example.compass_aac.viewmodel.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginMain : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val intent= Intent(this@LoginMain, TitleActivity::class.java)
            startActivity(intent)
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback) //위에서 생성한 콜백 인스턴스 붙여주기

//        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginBtn.isEnabled= false
        if (!binding.loginBtn.isEnabled){
            binding.loginBtn.setBackgroundColor(Color.parseColor("#CACACA"))
        }

        //전화번호 edittext 처리
        binding.loginPhoneEdt.addTextChangedListener { editable ->
            editable?.let {
                checkLoginButtonStatus()
                viewModel.updateUserLoginPhone(it.toString())
            }
        }

        //비밀번호 edittext 처리
        binding.loginPwEdt.addTextChangedListener { editable ->
            editable?.let {
                checkLoginButtonStatus()
                viewModel.updateUserLoginPassword(it.toString())
            }
        }


        //로그인 버튼 눌렀을 때
        binding.loginBtn.setOnClickListener {
            viewModel.CheckLogin()
        }

        binding.loginRegisterBtn.setOnClickListener {
            val intent = Intent(this, RegisterMain::class.java)
            startActivity(intent)
        }

        //뒤로가기
        binding.loginBackBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


        viewModel.loginresult.observe(this){ result ->
            if(result.isSuccess){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "로그인이 되지 않았습니다. 다시 시도해주세요", Toast.LENGTH_SHORT).show()
            }
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
        if (loginBtn.isEnabled){
            loginBtn.setBackgroundColor(Color.parseColor("#000000"))
        }

    }

}