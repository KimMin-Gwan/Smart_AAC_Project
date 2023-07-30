package com.example.compass_aac.view.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.compass_aac.R
import com.example.compass_aac.view.voiceaac.ChooseWordPass

class PassCategoryAdapter(private var categories: List<String>) :
    RecyclerView.Adapter<PassCategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryName: TextView = view.findViewById(R.id.category_name)
        val button: Button = view.findViewById(R.id.category_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_choose_pass_category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryName.text = categories[position]
        val selectedCategory = categories[position]
        // TextView를 클릭할 때, 해당 카테고리 이름을 로그로 출력
        holder.button.setOnClickListener {view->
            val context = view.context
            val intent = Intent(context, ChooseWordPass::class.java)
            intent.putExtra("eledtedCategory", selectedCategory)
            context.startActivity(intent)
            Log.d("PassCategoryAdapter", "Category clicked: $selectedCategory")
        }
    }

    override fun getItemCount() = categories.size

    fun submitList(newCategories: List<String>) {
        categories = newCategories
        notifyDataSetChanged()
    }
}