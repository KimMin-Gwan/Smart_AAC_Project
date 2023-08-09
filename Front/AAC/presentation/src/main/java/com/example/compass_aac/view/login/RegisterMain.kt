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

package com.example.compass_aac.view.login

import android.content.ContentValues
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityRegisterMainBinding
import com.example.compass_aac.viewmodel.login.RegisterViewModel
import com.example.compass_aac.view.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern

@AndroidEntryPoint
class RegisterMain : AppCompatActivity() {

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val intent= Intent(this@RegisterMain, TitleActivity::class.java)
            startActivity(intent)
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback) //위에서 생성한 콜백 인스턴스 붙여주기

        binding.registerNextBtn.isEnabled = false
        if (!binding.registerNextBtn.isEnabled){
            binding.registerNextBtn.setBackgroundColor(Color.parseColor("#CACACA"))
        }

//        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

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
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }

        //뒤로가기
        binding.registerBackBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        viewModel.registerResult.observe(this){result ->
            if(result.isSuccess){
                Toast.makeText(this, "회원가입 완료하였습니다. 로그인해주세요.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, TitleActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"회원가입에 실패했습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
            }
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




