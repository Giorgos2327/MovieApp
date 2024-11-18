package com.aliric.movieapp.screens

import androidx.compose.runtime.Composable
import com.aliric.movieapp.viewmodel.MovieViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel){

    //no need for observeAsState,we are not using
    // LiveData,we are using MutableStateOf

    //Any change in 'movie' state var , it'll trigger
    // an automatic recomposition to this 'MovieScreen' composable

    val moviesList=viewModel.movies
    MovieList(movies = moviesList)

}