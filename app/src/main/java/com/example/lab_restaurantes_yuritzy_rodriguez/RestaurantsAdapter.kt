package com.example.lab_restaurantes_yuritzy_rodriguez

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RestaurantsAdapter(private val items: List<Restaurant>): RecyclerView.Adapter<RestaurantsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)

        return RestaurantsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        val item = items[position]

        Glide.with(holder.itemView).load(item.photoOne).into(holder.image)
        holder.name.text = item.name
        holder.grade.text = item.grade.toString()
        holder.year.text = item.year.toString()
        holder.cost.text = item.cost.toString()
        holder.review.text = item.review
        holder.address.text = item.address

        holder.itemView.setOnClickListener { view ->
            view.context.startActivity(Intent(view.context, RestaurantDetailActivity::class.java)
                .putExtra("ID", item.id))
        }
    }

    override fun getItemCount(): Int = items.size

}