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
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.compass_aac.databinding.ActivityRegisterMainBinding
import com.example.compass_aac.viewmodels.RegisterViewModel
import com.example.compass_aac.views.MainActivity


class RegisterMain : AppCompatActivity() {
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding.registerNameEdt.addTextChangedListener { editable ->
            editable?.let {
                viewModel.updateUserName(it.toString())
            }
        }

        binding.registerPhoneEdt.addTextChangedListener { editable ->
            editable?.let {
                viewModel.updateUserPhone(it.toString())
            }
        }


        binding.registerPwEdt.addTextChangedListener { editable ->
            editable?.let {
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


}




