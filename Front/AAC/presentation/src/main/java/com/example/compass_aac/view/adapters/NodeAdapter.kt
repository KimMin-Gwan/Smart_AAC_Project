package com.example.compass_aac.view.adapters

import android.app.Application
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
import dagger.hilt.android.qualifiers.ApplicationContext


class NodeAdapter(private var childTree: ArrayList<Tree_Node>, private val context: Context) : RecyclerView.Adapter<NodeAdapter.ViewHolder>() {

    interface ItemClick{ //인터페이스
        fun onClick(view: View, treeNode: Tree_Node)
    }

    var itemClick: ItemClick? = null

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
        val newName = childTree[position].getName().replace(" ", "\n")
        holder.chooseWord.text = newName
        val treeNode = childTree[position]


        holder.chooseWord.setOnClickListener{
            Log.d("선택된 값", treeNode.getName())
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


//    fun StoreChildId(childNode: ArrayList<Tree_Node>){
//
//        val dataSet : MutableList<Int> = mutableListOf()
//        val currentdataSize = totaldataSet.size
//        //초기 해쉬맵 객체 선언
//        for (childnode in childNode){
//            var size = 0
//            if(size == childNode.size-1)
//                break
//            dataSet.add(childnode.getId())
//            size += 1
//        }
//        totaldataSet.add(dataSet)
//        t_hashMap[layer] = dataSet
//
//        layer += 1
//        Log.d("currentdataSize" , dataSet.size.toString())
//        Log.d("hashmap", t_hashMap.toString())
//        Log.d("dataSet", totaldataSet.toString())
//
//
//        UpdateChild(childNode)

//    }

    fun UpdateChild(childNode : ArrayList<Tree_Node>, selectedword : ArrayList<String>){
        if(childNode.isEmpty()){
            val intent = Intent(context,ShowSelectedWord::class.java)
            intent.putExtra("selectedword", selectedword)
            context.startActivity(intent)
        }
        childTree= childNode
        notifyDataSetChanged()

    }


}