package com.example.compass_aac.view.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityCustomizingBinding
import com.example.compass_aac.viewmodel.user.UserPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Customizing : AppCompatActivity() {

    private val viewModel : UserPageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCustomizingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.customizeEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // 텍스트가 변경되기 전에 호출됩니다.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // 텍스트가 변경되는 동안 호출됩니다.
            }

            override fun afterTextChanged(s: Editable) {
                // 텍스트가 변경된 후에 호출됩니다.
                Log.d("s", s.toString())
                viewModel.updateCustomize(s.toString())

            }
        })

        binding.customizeOkBtn.setOnClickListener {
            val customedText = viewModel.customize.value
            if (customedText != null) {
                viewModel.fixedText(customedText)
            }
            else{
                Toast.makeText(this, "글을 작성해주세요.", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent(this, UserPage::class.java)
            startActivity(intent)
        }

        viewModel.fixedText.observe(this){
            Toast.makeText(this, "수정된 문장: $it", Toast.LENGTH_SHORT).show()
        }

    }
}