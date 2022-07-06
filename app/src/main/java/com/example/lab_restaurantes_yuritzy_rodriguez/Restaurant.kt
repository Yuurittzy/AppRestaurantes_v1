package com.example.lab_restaurantes_yuritzy_rodriguez

import com.google.gson.annotations.SerializedName

data class Restaurant(@SerializedName("id") val id: Int?,
                      @SerializedName("nombre") val name: String?,
                      @SerializedName("calificacion") val grade: Double?,
                      @SerializedName("año") val year: Int?,
                      @SerializedName("costopromedio") val cost: Int?,
                      @SerializedName("photo") val photoOne: String?,
                      @SerializedName("photo2") val photoTwo: String?,
                      @SerializedName("photo3") val photoThree: String?,
                      @SerializedName("photo4") val photoFour: String?,
                      @SerializedName("photo5") val photoFive: String?,
                      @SerializedName("reseña") val review: String?,
                      @SerializedName("direccion") val address: String?)