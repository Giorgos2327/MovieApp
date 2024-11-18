package com.aliric.movieapp.repository

import android.content.Context
import com.aliric.movieapp.retrofit.Movie
import com.aliric.movieapp.retrofit.RetrofitInstance
import com.aliric.movieapp.room.MovieDAO
import com.aliric.movieapp.room.MoviesDB

class MovieRepository(context:Context) {

    suspend fun getMoviesFromOnlineApi(apiKey:String):List<Movie>{
        return RetrofitInstance.api.getMovies(apiKey).results
    }

    private val db=MoviesDB.getInstance(context)
    private val movieDao:MovieDAO=db.moviesDao


    suspend fun getMoviesFromDB():List<Movie>{
        return movieDao.getAllMoviesInDB()
    }

    suspend fun insertMoviesIntoDB(movies:List<Movie>){
        return movieDao.insertMoviesList(movies)
    }

    suspend fun insertMovieIntoDB(movie:Movie){
        return movieDao.insert(movie)
    }
}