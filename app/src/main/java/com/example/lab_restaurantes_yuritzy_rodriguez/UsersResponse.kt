package com.example.lab_restaurantes_yuritzy_rodriguez

import com.google.gson.annotations.SerializedName

data class UsersResponse(@SerializedName("users") val users: List<User>)