package com.example.lab_restaurantes_yuritzy_rodriguez

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantsActivity : AppCompatActivity() {

    private val service by lazy { RetrofitProvider.retrofit.create(RestaurantsApi::class.java) }

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView_restaurants) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)
        getRestaurants()
    }

    private fun getRestaurants() {
        service.getRestaurants().enqueue(object: Callback<RestaurantsResponse> {
            override fun onResponse(call: Call<RestaurantsResponse>, response: Response<RestaurantsResponse>) {
                recyclerView.layoutManager = LinearLayoutManager(this@RestaurantsActivity)
                recyclerView.adapter = RestaurantsAdapter(response.body()?.restaurants?: emptyList())
            }

            override fun onFailure(call: Call<RestaurantsResponse>, t: Throwable) {

            }
        })
    }

}