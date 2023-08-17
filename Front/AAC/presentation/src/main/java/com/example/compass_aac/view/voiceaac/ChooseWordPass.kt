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
import android.os.PersistableBundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import android.view.View
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
import com.example.data.source.remote.Tree_Node
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ChooseWordPass() : AppCompatActivity() {

    private lateinit var adapter: NodeAdapter

    private val viewModel: ChooseWordPassViewModel by viewModels()

    // ViewBinding 객체 선언
    private lateinit var binding: ActivityChooseWordPassBinding

    private lateinit var category : String
    private lateinit var child_list :ArrayList<Tree_Node>

    //클릭한 단어들 계층별로 해쉬맵에 저장
    private val clickedWord : HashMap<Int, String> =  hashMapOf()

    private val selectedWord : ArrayList<String> = arrayListOf()
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val intent = Intent(this@ChooseWordPass, PassCategory::class.java)
            startActivity(intent)
            Log.e(ContentValues.TAG, "뒤로가기 클릭")
            // 뒤로가기 시 실행할 코드
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChooseWordPassBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 카테고리 변경을 관찰
        viewModel.categories.observe(this) {

            child_list = viewModel.processUpdateNodes()!!

            adapter = NodeAdapter(child_list, this)
            binding.recyclerViewPass.layoutManager = GridLayoutManager(this, 3)
            binding.recyclerViewPass.adapter = adapter

            //override
            adapter.itemClick = object : NodeAdapter.ItemClick {
                override fun onClick(view: View, treeNode: Tree_Node) {
                    Log.d("클릭된 단어", treeNode.getName())
                    CheckHashMap(treeNode.getName())
                    selectedWord.add(treeNode.getName())
                    val childTree = viewModel.getAAC_Tree(treeNode.getId())
                    Log.d("자식노드", childTree.toString())

                    adapter.UpdateChild(childTree, selectedWord)

                }
            }
        }

        // 액티비티가 처음 시작될 때 카테고리를 설정
        var selectedCategory = intent.getStringExtra("selectedCategory")
        val categoryselected = selectedCategory
        if (selectedCategory != null) {
            category = selectedCategory
            Log.d("category", category)
            Log.d("selectedCategory", selectedCategory)
            viewModel.storeCategory(selectedCategory)
            child_list = viewModel.processNodes(selectedCategory)
        }


        //선택완료하기
        binding.selectwordBtn.setOnClickListener {
            viewModel.UpdateSelectedWord(selectedWord)
            val intent = Intent(this, ShowSelectedWord::class.java)
            intent.putExtra("selectedword",selectedWord )
            intent.putExtra("selectedCategory", categoryselected)
            startActivity(intent)
        }

        //뒤로가기 구현
        binding.choosePassBackBtn.setOnClickListener {
            Log.d("뒤로가기", "뒤로가기")
            onBackPressedDispatcher.onBackPressed()
        }
        this.onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

    }


//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        Log.d("category", category)
//        outState.putString(SELECTED_CATEGORY,  category)
//    }

    override fun onPause() {
        super.onPause()
        Log.d("pause", "pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("stop", "stop")

    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("destroy", "Destroy")
    }

    companion object {
        const val SELECTED_CATEGORY = "selectedCategory"
    }


    private fun CheckHashMap(clickedWord :String){

    }
}