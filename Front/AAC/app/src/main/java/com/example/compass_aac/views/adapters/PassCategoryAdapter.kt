package com.example.compass_aac.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.compass_aac.R

class PassCategoryAdapter(context: Context, private val categories: List<String>) :
    ArrayAdapter<String>(context, R.layout.activity_choose_pass_category_item, categories) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.activity_choose_pass_category_item, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.categoryName.text = categories[position]

        return view
    }

    private class ViewHolder(view: View) {
        val categoryName: TextView = view.findViewById(R.id.category_name)
    }
}