package com.example.compass_aac.view.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.compass_aac.R
import com.example.compass_aac.view.voiceaac.ChooseWordPass

class PassCategoryAdapter(private var categories: List<String>) :
    RecyclerView.Adapter<PassCategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryName: TextView = view.findViewById(R.id.category_name)
        val categoryImage : ImageView = view.findViewById(R.id.category_img)
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
        when(selectedCategory){
            "카페" -> {
                holder.categoryImage.setImageResource(R.drawable.categorycafe)
            }
            "식당" -> {
                holder.categoryImage.setImageResource(R.drawable.categoryrestaurant)
            }
            "병원" ->{
                holder.categoryImage.setImageResource(R.drawable.categoryhospital)
            }
            "지하철" ->{
                holder.categoryImage.setImageResource(R.drawable.categorysubway)
            }
            "베이커리"->{
                holder.categoryImage.setImageResource(R.drawable.categorybakery)
            }
            "편의점" ->{
                holder.categoryImage.setImageResource(R.drawable.categoryconvenience)
            }
            "문구점" -> {
                holder.categoryImage.setImageResource(R.drawable.categorygrocerystore)
            }
            "마트" -> {
                holder.categoryImage.setImageResource(R.drawable.categorymart)
            }
            "서점" -> {
                holder.categoryImage.setImageResource(R.drawable.categorybooks)
            }
            "도서관" -> {
                holder.categoryImage.setImageResource(R.drawable.categorylibrary)
            }
            "영화관" -> {
                holder.categoryImage.setImageResource(R.drawable.categorycinema)
            }
            "미용실" ->{
                holder.categoryImage.setImageResource(R.drawable.categorysalon)
            }

        }
        // TextView를 클릭할 때, 해당 카테고리 이름을 로그로 출력
        holder.button.setOnClickListener {view->
            val context = view.context
            val intent = Intent(context, ChooseWordPass::class.java)
            intent.putExtra("selectedCategory", selectedCategory)
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