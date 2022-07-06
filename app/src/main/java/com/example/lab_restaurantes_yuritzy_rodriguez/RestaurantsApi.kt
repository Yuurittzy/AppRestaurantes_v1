package com.example.lab_restaurantes_yuritzy_rodriguez

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantsApi {

    @GET("api/restaurants/login/users")
    fun getUsersForLogin(): Call<UsersResponse>

    @GET("api/restaurants/retreive")
    fun getRestaurants(): Call<RestaurantsResponse>

    @GET("api/restaurants/{id}/retreive")
    fun getRestaurantById(@Path("id") id: Long): Call<Restaurant>

}