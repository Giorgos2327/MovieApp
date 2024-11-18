package com.aliric.movieapp.retrofit

data class MovieResponse(
    val pages:Int,
    val results:List<Movie>,
    val total_pages:Int,
    val total_results:Int
)
