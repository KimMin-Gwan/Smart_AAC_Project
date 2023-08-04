package com.example.compass_aac.view.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.compass_aac.R
import com.example.compass_aac.view.voiceaac.ShowSelectedWord
import com.example.data.source.remote.Tree_Node


class VoiceAdapter(private var childTree: ArrayList<Tree_Node>, private val context: Context) : RecyclerView.Adapter<VoiceAdapter.ViewHolder>() {

    interface ItemClick{ //인터페이스
        fun onClick(view: View, treeNode: Tree_Node)
    }

    var itemClick: ItemClick? = null

//    private var childTree: MutableList<String> = mutableListOf()

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val chooseWord: Button = view.findViewById(R.id.chooseWordVoiceTv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_choose_voice_word_voice, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount() = childTree.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.chooseWord.text = childTree[position].getName()
        val treeNode = childTree[position]

        holder.chooseWord.setOnClickListener{
            Log.d("선택된 값", treeNode.getId().toString())
            Log.d("t_hashMap", t_hashMap.keys.toString())
            for ((key, values) in t_hashMap) {
                if (values.contains(treeNode.getId())) {
                    Log.d("findLayer", key.toString())
                }
                else{
//                    itemClick?.onClick(it, treeNode)
                }
            }
            itemClick?.onClick(it, treeNode)

        }

    }
    var t_hashMap = HashMap<Int, List<Int>>()
    val totaldataSet : MutableList<List<Int>> = mutableListOf()
    var layer = 0

    fun UpdateChild(childNode : ArrayList<Tree_Node>, selectedword : ArrayList<String>){
        if(childNode.isEmpty()){
            val intent = Intent(context, ShowSelectedWord::class.java)
            intent.putExtra("selectedword", selectedword)
            context.startActivity(intent)
        }
        childTree= childNode
        notifyDataSetChanged()

    }


}