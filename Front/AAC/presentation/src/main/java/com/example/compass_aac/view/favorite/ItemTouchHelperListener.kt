package com.example.compass_aac.view.favorite

import androidx.recyclerview.widget.RecyclerView

interface ItemTouchHelperListener {
    fun onItemMove(from_position: Int, to_position: Int): Boolean
    fun onItemSwipe(position: Int)
    fun onRightClick(position: Int, viewHolder: RecyclerView.ViewHolder?)
}