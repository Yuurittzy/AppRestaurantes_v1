package com.example.lab_restaurantes_yuritzy_rodriguez

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("username") val username: String?,
                @SerializedName("password") val password: String?)