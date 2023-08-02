package com.example.compass_aac.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.compass_aac.R
import com.example.domain.repository.FindNodeRepository


class NodeAdapter(private var childTree: MutableList<String>, private val findNodeRepository: FindNodeRepository) : RecyclerView.Adapter<NodeAdapter.ViewHolder>() {


//    private var childTree: MutableList<String> = mutableListOf()

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val chooseWord: Button = view.findViewById(R.id.chooseWordPassTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_choose_word_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = childTree.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("childTree", childTree.toString())
        holder.chooseWord.text = childTree[position]

        val chooseWordTv = childTree[position]
        val storeWord= mutableListOf<String>()

        holder.chooseWord.setOnClickListener {view->
            val context = view.context
            Log.d("chooseWordTv",chooseWordTv)
            if (view.background == ContextCompat.getDrawable(context,R.drawable.button_clicked_color )) {
                view.setBackgroundResource(R.drawable.button_unclicked_color) // 버튼이 클릭 상태이면 클릭되지 않은 상태로 변경
            } else {
            view.setBackgroundResource(R.drawable.button_clicked_color) // 버튼이 클릭되지 않은 상태이면 클릭된 상태로 변경
        }
            storeWord.add(chooseWordTv)
            Log.d("storeWord", storeWord.toString())
            val childList =findNodeRepository.returnIndex(chooseWordTv)
            val childTree_List= findNodeRepository.MakeTree(childList)
            Log.d("childTree_List", childTree_List.toString())
            childTree.addAll(childTree_List)
            notifyDataSetChanged()

        }
    }

//    fun submitList(newCategories: List<String>) {
//        categories = newCategories
//        notifyDataSetChanged()
//    }

}