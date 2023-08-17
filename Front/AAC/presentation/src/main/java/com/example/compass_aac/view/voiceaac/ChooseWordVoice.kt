/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 음성인식에 따른 aac 선택하는 화면
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
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.example.compass_aac.databinding.ActivityChooseWordVoiceBinding
import com.example.compass_aac.view.adapters.NodeAdapter
import com.example.compass_aac.view.adapters.VoiceAdapter
import com.example.compass_aac.viewmodel.voiceaac.ChooseWordPassViewModel
import com.example.compass_aac.viewmodel.voiceaac.ChooseWordVoiceViewModel
import com.example.data.source.remote.Tree_Node
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ChooseWordVoice : AppCompatActivity() {

    //어댑터
    private lateinit var adapter: VoiceAdapter
    //뷰모델
    private val viewModel: ChooseWordVoiceViewModel by viewModels()
    //트리 노드
    private lateinit var childList :ArrayList<Tree_Node>

    //선택된 단어 (클릭된 단어)
    val selectedWord : ArrayList<String> = arrayListOf()

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val intent = Intent(this@ChooseWordVoice, HearVoice::class.java)
            startActivity(intent)
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩
        val binding = ActivityChooseWordVoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback)


        //음성 받아오기
        val voicetext = intent.getStringExtra("voiceText")
        binding.voiceText.text = "\"${voicetext}\""
        Log.d("voiceText", voicetext!! )

        //인식한 텍스트가 없을 때
        if (voicetext == "default"){
            Toast.makeText(this, "질문을 인식하지 못했습니다. 다시 한번 말씀해주세요.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HearVoice::class.java)
            startActivity(intent)
        }
        else{
            viewModel.getCategory(voicetext)
        }


        //받아온 음성 카테고리로 변환 후 관찰
        viewModel.category.observe(this){
            if (it.isSuccess){
                val childTree = viewModel.processUpdateNodes()
                adapter = VoiceAdapter(childTree!!,this)
                binding.recyclerViewVoice.layoutManager = GridLayoutManager(this, 3)
                binding.recyclerViewVoice.adapter = adapter

                //버튼 클릭 시
                adapter.itemClick = object : VoiceAdapter.ItemClick{
                    override fun onClick(view: View, treeNode: Tree_Node) {
                        Log.d("클릭된 단어", treeNode.getName())
                        selectedWord.add(treeNode.getName())
                        val childtree = viewModel.getAAC_Tree(treeNode.getId())
                        Log.d("자식노드", childtree.toString())

                        adapter.UpdateChild(childtree, selectedWord)

                    }

                }
            }
        }



        binding.selectWordVoiceBackBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.selectedWordVoiceBtn.setOnClickListener {
            val intent = Intent(this, ShowSelectedWord::class.java)

            startActivity(intent)

        }
    }

}