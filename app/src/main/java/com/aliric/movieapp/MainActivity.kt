 package com.aliric.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aliric.movieapp.repository.MovieRepository
import com.aliric.movieapp.room.MoviesDB
import com.aliric.movieapp.screens.MovieScreen
import com.aliric.movieapp.ui.theme.MovieAppTheme
import com.aliric.movieapp.viewmodel.MovieViewModel
import com.aliric.movieapp.viewmodel.MovieViewModelFactory

 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()




        //repository
        val repository=MovieRepository(applicationContext)

        //view model factory
        val viewModelFactory=MovieViewModelFactory(repository)

        //view model
        val movieViewModel=ViewModelProvider(this,viewModelFactory)[MovieViewModel::class.java]


        setContent {
            MovieAppTheme {

                Column {
                    Header()
                    MovieScreen(viewModel = movieViewModel)
                }



            }
        }
    }
}

@Composable
 fun Header(){

     Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
         .fillMaxWidth()
         .padding(16.dp)) {
         Text(
             text = "Movie App",
             fontSize = 32.sp,
             fontWeight = FontWeight.Bold
         )

         Text(
             text = "Get Popular Movies",
             fontSize = 16.sp, fontWeight = FontWeight.Bold
         )
     }
 }


