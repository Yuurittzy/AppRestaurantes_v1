package com.example.lab_restaurantes_yuritzy_rodriguez

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val image: ImageView = view.findViewById(R.id.imageView_restaurant)
    val name: TextView = view.findViewById(R.id.textView_name)
    val grade: TextView = view.findViewById(R.id.textView_grade)
    val year: TextView = view.findViewById(R.id.textView_year)
    val cost: TextView = view.findViewById(R.id.textView_cost)
    val review: TextView = view.findViewById(R.id.textView_review)
    val address: TextView = view.findViewById(R.id.textView_address)

}