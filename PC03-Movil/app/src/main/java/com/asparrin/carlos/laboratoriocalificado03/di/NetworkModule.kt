package com.asparrin.carlos.laboratoriocalificado03.di

import com.asparrin.carlos.laboratoriocalificado03.data.network.ApiClient
import org.koin.dsl.module

val networkModule = module {
    single { ApiClient.teacherService }
}