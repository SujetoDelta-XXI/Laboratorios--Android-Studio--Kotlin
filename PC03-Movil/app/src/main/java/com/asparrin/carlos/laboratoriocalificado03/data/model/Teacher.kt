package com.asparrin.carlos.laboratoriocalificado03.data.model

import com.google.gson.annotations.SerializedName

data class Teacher(
    @SerializedName("name")        val firstName:   String,
    @SerializedName("last_name")   val lastName:    String,
    @SerializedName("phone_number")val phoneNumber: String,
    @SerializedName("email")       val email:       String,
    @SerializedName("image_url")   val photoUrl:    String
)
