package com.aliric.movieapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aliric.movieapp.retrofit.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDB:RoomDatabase() {

    //DAO
    abstract val moviesDao:MovieDAO

    companion object{

        @Volatile
        private var INSTANCE:MoviesDB?=null

        fun getInstance(context:Context):MoviesDB{
            //ensuring that only one thread can execute the
            //block of code inside the block at any given time
            synchronized(this){
                var instance= INSTANCE
                if (instance==null){

                    //Creating the DB Object
                    instance=Room.databaseBuilder(
                        context = context.applicationContext,
                        MoviesDB::class.java,
                        "movies_db"
                    ).build()
                }
                INSTANCE=instance
                return instance
            }
        }
    }
}