package com.example.lab_restaurantes_yuritzy_rodriguez

import com.google.gson.annotations.SerializedName

data class RestaurantsResponse(@SerializedName("restaurantes") val restaurants: List<Restaurant>)