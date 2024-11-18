package com.aliric.movieapp.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") apiKey:String
    ):MovieResponse
}