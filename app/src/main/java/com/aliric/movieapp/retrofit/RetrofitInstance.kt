package com.aliric.movieapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URl="https://api.themoviedb.org/3/"

    val api:ApiService by lazy {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}