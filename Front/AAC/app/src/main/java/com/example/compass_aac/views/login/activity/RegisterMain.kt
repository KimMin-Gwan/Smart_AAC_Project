/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 회원가입 메인 화면
 * - Viewmodel과 연결
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.views.login.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityRegisterMainBinding
import com.example.compass_aac.viewmodels.RegisterViewModel
import com.example.compass_aac.views.MainActivity
import java.util.regex.Pattern


class RegisterMain : AppCompatActivity() {
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerNextBtn.isEnabled = false
        if (!binding.registerNextBtn.isEnabled){
            binding.registerNextBtn.setBackgroundColor(Color.parseColor("#CACACA"))
        }

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding.registerNameEdt.addTextChangedListener { editable ->
            editable?.let {
                val pattern = Pattern.compile("^[가-힣ㄱ-ㅎㅏ-ㅣ]*$")  // 한글 및 공백 정규 표현식
                val matcher = pattern.matcher(editable)

                if (!matcher.matches() && editable.isNotEmpty()) {
                    Toast.makeText(this, "이름은 한글만 입력 가능합니다.", Toast.LENGTH_SHORT).show()
                }
                else{
                    checkRegisterButtonStatus()
                    viewModel.updateUserName(it.toString())
                }
            }
        }
        binding.registerPhoneEdt.addTextChangedListener { editable ->
            editable?.let {
                checkRegisterButtonStatus()
                viewModel.updateUserPhone(it.toString())
            }
        }


        binding.registerPwEdt.addTextChangedListener { editable ->
            editable?.let {
                checkRegisterButtonStatus()
                viewModel.updateUserPassword(it.toString())
            }
        }

        //완료 버튼
        binding.registerNextBtn.setOnClickListener {
            viewModel.registerUser()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //이전으로 돌아가기
        binding.registerBackBtn.setOnClickListener {
            onBackPressed()
        }
    }
    // EditText 입력 상태를 확인하여 로그인 버튼 상태 업데이트
    fun checkRegisterButtonStatus() {
        val registNameEdt = findViewById<EditText>(R.id.register_name_edt)
        val registPhoneEdt = findViewById<EditText>(R.id.register_phone_edt)
        val registPwEdt = findViewById<EditText>(R.id.register_pw_edt)
        val registBtn = findViewById<Button>(R.id.register_next_btn)
        val name = registNameEdt.text.toString().trim()
        val phone = registPhoneEdt.text.toString().trim()
        val password = registPwEdt.text.toString().trim()

        // 모든 EditText가 비어있지 않은 경우 로그인 버튼 활성화
        registBtn.isEnabled = name.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty()
        if (registBtn.isEnabled){
            registBtn.setBackgroundColor(Color.parseColor("#000000"))
        }

    }

}




