package com.example.rickandmorty.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val BASE_URL = "https://rickandmortyapi.com/api/"

    var retrofit: Retrofit? = null

    private fun provideRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    val provideApiService: ApiService
        get() = provideRetrofit().create(ApiService::class.java)
}