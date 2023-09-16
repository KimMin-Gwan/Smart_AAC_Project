package com.example.compass_aac.view.adapters

import android.app.Application
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
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.compass_aac.R
import com.example.compass_aac.view.voiceaac.ShowSelectedWord
import com.example.data.source.remote.Tree_Node
import com.example.json.Node
import dagger.hilt.android.qualifiers.ApplicationContext


class NodeAdapter(private var childTree: ArrayList<Tree_Node>, private val context: Context) : RecyclerView.Adapter<NodeAdapter.ViewHolder>() {

    init {
//        fillEmptyNodes()
    }

    interface ItemClick {
        fun onClick(view: View, treeNode: Tree_Node)
    }

    var itemClick: ItemClick? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chooseWord: Button = view.findViewById(R.id.chooseWordPassBtn)
        val chooseName : TextView = view.findViewById(R.id.chooseWordName)
        val chooseImg : ImageView = view.findViewById(R.id.chooseWordPassImg)
//        val downarrow: ImageView = view.findViewById(R.id.downArrow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_choose_word_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = childTree.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val treeNode = childTree[position]

        // 화살표 보이기: 현재 위치가 마지막 줄의 가운데 버튼인 경우에만
//        holder.downarrow.visibility =
//            if ((position % 3 == 1) && ((position / 3) == (itemCount - 1) / 3)) View.VISIBLE else View.INVISIBLE

        if (childTree[position].getName() == "") {
            holder.chooseWord.isEnabled = false
            holder.chooseWord.visibility = View.INVISIBLE
        } else {
            holder.chooseWord.isEnabled = true
            holder.chooseWord.visibility = View.VISIBLE

            val newName = treeNode.getName().replace(" ", "\n")
            holder.chooseName.text = newName
        }

        //클릭시 에니메이션 적용
        val scaleAnimation = AnimationUtils.loadAnimation(context, R.anim.scale_animation)

        holder.chooseWord.setOnClickListener {
            it.startAnimation(scaleAnimation)
            it.isSelected = !it.isSelected
            itemClick?.onClick(it, treeNode)
        }

    }

    fun UpdateChild(childNode: ArrayList<Tree_Node>, selectedword: ArrayList<String>) {
        if (childNode.isEmpty()) {
            val intent = Intent(context, ShowSelectedWord::class.java)
            intent.putExtra("selectedword", selectedword)
            context.startActivity(intent)
        }
        val positionStart = itemCount
//        childTree.addAll(childNode)
        childTree = childNode
//        fillEmptyNodes()
//        notifyItemRangeInserted(positionStart, childTree.size - positionStart)
        notifyDataSetChanged()
    }


    //빈노드 생성하기
//    private fun fillEmptyNodes() {
//        var extraItems = 0
//        if (childTree.size % 3 != 0) {
//            extraItems = 3 - (childTree.size % 3)
//        }
//
//        for (i in 0 until extraItems) {
//            val emptyNode = Node().apply { node_init(-1, "", arrayListOf()) }
//            val emptyTreeNode = Tree_Node(emptyNode)
//            childTree.add(emptyTreeNode)
//        }
//    }
}