package com.asparrin.carlos.laboratoriocalificado03.data.model

import com.google.gson.annotations.SerializedName

data class TeachersResponse(
    @SerializedName("teachers")
    val teachers: List<Teacher>
)
