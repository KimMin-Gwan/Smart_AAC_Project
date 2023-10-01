/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 긴급 AAC 카테고리 선택화면
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.view.urgencyaac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.compass_aac.databinding.ActivityUrgencyCategoryBinding
import com.example.compass_aac.viewmodel.urgencyaac.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UrgencyCategory : AppCompatActivity() {

    private val viewModel : CategoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩
        val binding = ActivityUrgencyCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hospital.setOnClickListener {
            viewModel.getCategory("hospital")
            val intent = Intent(this, UrgencySentence::class.java)
            intent.putExtra("category", "의료 상황")
            startActivity(intent)
        }

        binding.danger.setOnClickListener {
            viewModel.getCategory("danger")
            val intent = Intent(this, UrgencySentence::class.java)
            intent.putExtra("category", "안전/위험 상황")
            startActivity(intent)
        }

        binding.location.setOnClickListener {
            viewModel.getCategory("location")
            val intent = Intent(this, UrgencySentence::class.java)
            intent.putExtra("category", "위치/실종 상황")
            startActivity(intent)
        }
        binding.etc.setOnClickListener {
            viewModel.getCategory("etc")
            val intent = Intent(this, UrgencySentence::class.java)
            intent.putExtra("category", "기타 긴급 상황")
            startActivity(intent)
        }

        binding.imageButton.setOnClickListener {
            finish()
        }


    }
}