package com.example.compass_aac.view.favorite
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.compass_aac.R
//import com.example.domain.model.favorite
//
//class FavoriteAdapter(private var favorites: List<favorite>) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val sentenceTextView: TextView = itemView.findViewById(R.id.sentenceItem)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.activity_favorite_list, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val favorite = favorites[position]
//        holder.sentenceTextView.text = favorite.sentence
//    }
//
//    override fun getItemCount(): Int {
//        return favorites.size
//    }
//
//    // 데이터 갱신
//    fun updateData(newFavorites: List<favorite>) {
//        favorites = newFavorites
//        notifyDataSetChanged()
//    }
//}
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.compass_aac.R
import com.example.compass_aac.view.adapters.NodeAdapter
import com.example.data.source.remote.Tree_Node
import com.example.domain.model.favorite

class FavoriteAdapter : ListAdapter<favorite, FavoriteAdapter.ViewHolder>(DiffCallback), ItemTouchHelperListener  {

    interface ItemClick {
        fun onDelete(view: View, id: Int )
    }

    var itemClick: ItemClick? = null


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sentenceTextView: TextView = itemView.findViewById(R.id.sentenceItem)
        val textNumber: TextView = itemView.findViewById(R.id.textView10)

    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<favorite>() {
            override fun areItemsTheSame(oldItem: favorite, newItem: favorite): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: favorite, newItem: favorite): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_favorite_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favorite = getItem(position)
        holder.sentenceTextView.text = favorite.sentence
        holder.textNumber.text = (position + 1).toString()

    }

    override fun onItemMove(from_position: Int, to_position: Int): Boolean = false


    override fun onItemSwipe(position: Int) {
        TODO("Not yet implemented")
    }

//    override fun onLeftClick(position: Int, viewHolder: RecyclerView.ViewHolder?) {
//        val context = viewHolder?.itemView?.context
//        Toast.makeText(context, "LeftClick", Toast.LENGTH_SHORT).show()
//    }

    // FavoriteAdapter.kt
    override fun onRightClick(position: Int, viewHolder: RecyclerView.ViewHolder?) {
        val context = viewHolder?.itemView?.context
        val favorite = getItem(position)

       itemClick?.onDelete(viewHolder!!.itemView, favorite.id.toInt() )

        // 삭제한 아이템을 RecyclerView에서 제거
        notifyItemRemoved(position)

        Toast.makeText(context, "RightClick", Toast.LENGTH_SHORT).show()
    }

}
