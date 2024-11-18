package com.aliric.movieapp.retrofit

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
data class Movie(

    @PrimaryKey
    val id:Int,


    val title:String,
    val overview:String,
    val poster_path:String,
    val release_date:String
)
