package com.aliric.movieapp.room

import androidx.room.Dao
import androidx.room.Insert
import com.aliric.movieapp.retrofit.Movie
import retrofit2.http.Query

@Dao
interface MovieDAO {

    @Insert
    suspend fun insert(movie:Movie)

    @Insert
    suspend fun insertMoviesList(movie:List<Movie>)


    @androidx.room.Query("SELECT * FROM movies_table")
    suspend fun getAllMoviesInDB():List<Movie>

}