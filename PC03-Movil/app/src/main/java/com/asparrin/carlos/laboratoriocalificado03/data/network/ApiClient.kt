package com.asparrin.carlos.laboratoriocalificado03.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://private-effe28-tecsup1.apiary-mock.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val teacherService: TeacherService = retrofit.create(TeacherService::class.java)
}
