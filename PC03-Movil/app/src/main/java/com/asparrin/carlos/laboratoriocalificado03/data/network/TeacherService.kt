package com.asparrin.carlos.laboratoriocalificado03.data.network

import com.asparrin.carlos.laboratoriocalificado03.data.model.TeachersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface TeacherService {
    @GET
    suspend fun getTeachers(@Url url: String): Response<TeachersResponse>
}

