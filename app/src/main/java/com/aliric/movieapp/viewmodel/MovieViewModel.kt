package com.aliric.movieapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliric.movieapp.repository.MovieRepository
import com.aliric.movieapp.retrofit.Movie
import kotlinx.coroutines.launch

class MovieViewModel(repository: MovieRepository):ViewModel() {

    //ViewModel uses MutableStateOf<> instead of LiveData
    // Allowing direct Compose state handling

    //when the value of 'movies' changes,Compose will
    //automatically recompose the parts of the UI that depend
    // on this state

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set //only 'MovieViewModel' can change 'movies'


    // The online Movies
    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set


    //The offline Movies
    var moviesFromRoomDB by mutableStateOf<List<Movie>>(emptyList())
        private set


    //ViewModelScope:launch a coroutine in the scope of ViewModel,
    //which means that coroutine will be tied to the lifecycle of
    //the viewmodel


    init {
        viewModelScope.launch {
            try {
                moviesFromApi=repository
                    .getMoviesFromOnlineApi("1c27a4d25f2dfd5a77bd7be585bc84d2")


                //Insert Movies into ROOM DB
                repository.insertMoviesIntoDB(moviesFromApi)

                //Assigning 'movies' to MoviesFromApi
                movies=moviesFromApi
            }catch (e:Exception){
                //Fetch The data from ROOM DB

                moviesFromRoomDB=repository.getMoviesFromDB()

                movies=moviesFromRoomDB
            }

        }
    }


}