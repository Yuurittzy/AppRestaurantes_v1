package com.example.lab_restaurantes_yuritzy_rodriguez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantDetailActivity : AppCompatActivity() {

    private val service by lazy { RetrofitProvider.retrofit.create(RestaurantsApi::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        intent.extras?.let {
            val id = it.get("ID") as Int

            service.getRestaurantById(id.toLong()).enqueue(object: Callback<Restaurant> {
                override fun onResponse(call: Call<Restaurant>, response: Response<Restaurant>) {
                    val restaurant = response.body()

                    Glide.with(this@RestaurantDetailActivity).load(restaurant?.photoOne).into(findViewById(R.id.imageView_detail_restaurant))
                    Glide.with(this@RestaurantDetailActivity).load(restaurant?.photoTwo).into(findViewById(R.id.imageView_detail_restaurant_two))
                    Glide.with(this@RestaurantDetailActivity).load(restaurant?.photoThree).into(findViewById(R.id.imageView_detail_restaurant_three))
                    findViewById<TextView>(R.id.textView_detail_name).text = restaurant?.name
                    findViewById<TextView>(R.id.textView_detail_grade).text = restaurant?.grade.toString()
                    findViewById<TextView>(R.id.textView_detail_year).text = restaurant?.year.toString()
                    findViewById<TextView>(R.id.textView_detail_cost).text = restaurant?.cost.toString()
                    findViewById<TextView>(R.id.textView_detail_review).text = restaurant?.review
                    findViewById<TextView>(R.id.textView_detail_address).text = restaurant?.address
                }

                override fun onFailure(call: Call<Restaurant>, t: Throwable) {

                }

            })
        }
    }

}