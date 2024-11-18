package com.aliric.movieapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.aliric.movieapp.retrofit.Movie

@Composable
fun MovieItem(movie: Movie) {

    Card(elevation = CardDefaults
        .cardElevation(8.dp),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),

        border = BorderStroke(2.dp, Color.Gray)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {

            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500/${movie.poster_path}",
                contentDescription = "Movie Image",

                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier =Modifier.width(8.dp))

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.labelLarge)
                Text(text = movie.overview, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Release Date:${movie.release_date}", style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold))

            }

        }

    }
}