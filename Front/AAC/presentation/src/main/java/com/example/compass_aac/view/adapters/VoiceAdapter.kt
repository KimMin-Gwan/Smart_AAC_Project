package com.example.compass_aac.view.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compass_aac.R
import com.example.compass_aac.view.voiceaac.ShowSelectedWord
import com.example.data.source.remote.Tree_Node
import com.example.json.Node


class VoiceAdapter(private var childTree: ArrayList<Tree_Node>, private val context: Context) : RecyclerView.Adapter<VoiceAdapter.ViewHolder>() {

    interface ItemClick{ //인터페이스
        fun onClick(view: View, treeNode: Tree_Node)
    }

    var itemClick: ItemClick? = null

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val chooseWord: Button = view.findViewById(R.id.chooseWordVoiceBtn)
        val chooseVoiceName : TextView = view.findViewById(R.id.chooseWordVoiceName)
//        val chooseVoiceImg : ImageView = view.findViewById(R.id.chooseWordVoiceImg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_choose_voice_word_voice, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = childTree.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val treeNode = childTree[position]

        if (childTree[position].getName() == "") {
            holder.chooseWord.isEnabled = false
            holder.chooseWord.visibility = View.INVISIBLE
        } else {
            holder.chooseWord.isEnabled = true
            holder.chooseWord.visibility = View.VISIBLE
            //이미지 url로 처리
            val urlId = treeNode.getId()
            val url = "http://13.125.205.99/images/$urlId.png"
//            Glide.with(context).load(url).error(R.drawable.baseline_error_outline_24).into(holder.chooseVoiceImg)


//            val newName = treeNode.getName().replace(" ", "\n")
            holder.chooseVoiceName.text = treeNode.getName()
        }

        //클릭시 에니메이션 적용
        val scaleAnimation = AnimationUtils.loadAnimation(context, R.anim.scale_animation)

        holder.chooseWord.setOnClickListener {
            it.startAnimation(scaleAnimation)
            it.isSelected = !it.isSelected
            itemClick?.onClick(it, treeNode)
        }

    }

    fun UpdateChild(childNode : ArrayList<Tree_Node>, selectedword : ArrayList<String>){
        if(childNode.isEmpty()){
            val intent = Intent(context, ShowSelectedWord::class.java)
            intent.putExtra("selectedword", selectedword)
            context.startActivity(intent)
        }
        val positionStart = itemCount
//        childTree.addAll(childNode)
        childTree = childNode
        notifyItemRangeInserted(positionStart, childTree.size - positionStart)

    }

}