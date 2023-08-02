/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 카테고리에 따른 처음 보여지는 default aac 보여지는화면
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.view.voiceaac

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.compass_aac.R
import com.example.compass_aac.databinding.ActivityChooseWordPassBinding
import com.example.compass_aac.databinding.ActivityPassCategoryBinding
import com.example.compass_aac.view.adapters.NodeAdapter
import com.example.compass_aac.viewmodel.voiceaac.ChooseWordPassViewModel
import com.example.compass_aac.viewmodel.voiceaac.HearVoiceViewModel
import com.example.data.repository.FindNodeRepositoryImpl
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ChooseWordPass() : AppCompatActivity() {

    private lateinit var adapter: NodeAdapter
    private val viewModel: ChooseWordPassViewModel by viewModels()
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val intent = Intent(this@ChooseWordPass, PassCategory::class.java)
            startActivity(intent)
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }
    // ViewBinding 객체 선언
    private lateinit var binding: ActivityChooseWordPassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChooseWordPassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedCategory = intent.getStringExtra("selectedCategory")
        Log.d("selectedCategory", selectedCategory!!)

        viewModel.categories.observe(this){
            viewModel.updateCategory(it)
        }

        binding.selectwordBtn.setOnClickListener {
            val intent = Intent(this, ShowSelectedWord::class.java)
            startActivity(intent)
        }

        binding.choosePassBackBtn.setOnClickListener {
            Log.d("뒤로가기", "뒤로가기")
            onBackPressedDispatcher.onBackPressed()
        }
        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback)


        val categoryIndex = viewModel.returnIndex(selectedCategory)
        val childTree = viewModel.MakeTree(categoryIndex)
        Log.d("childTree", childTree.toString())


        val findNodeRepository = viewModel.getFindNodeRepositoryImpl()

        adapter = NodeAdapter(childTree,findNodeRepository)
        binding.recyclerViewPass.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerViewPass.adapter = adapter
    }
}