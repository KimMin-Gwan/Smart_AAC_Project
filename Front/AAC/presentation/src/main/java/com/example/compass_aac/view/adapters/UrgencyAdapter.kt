package com.example.compass_aac.view.adapters

import android.content.Context
import android.content.Intent
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
import com.example.compass_aac.view.urgencyaac.FullSrceen
import com.example.compass_aac.view.voiceaac.ShowSelectedWord
import com.example.data.source.remote.Tree_Node


class UrgencyAdapter(private var childTree: ArrayList<Tree_Node>, private val context: Context) : RecyclerView.Adapter<UrgencyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sentenceList: TextView = view.findViewById(R.id.sentenceList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_urgency_sentence_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = childTree.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val treeNode = childTree[position]

        holder.sentenceList.text = treeNode.getName()

        holder.sentenceList.setOnClickListener {
            val intent = Intent(holder.itemView.context, FullSrceen::class.java)
            intent.putExtra("urgencySentence", treeNode.getName())
            holder.itemView.context.startActivity(intent)


        }
    }


}
