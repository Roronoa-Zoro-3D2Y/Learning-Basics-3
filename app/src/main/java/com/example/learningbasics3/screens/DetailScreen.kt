package com.example.learningbasics3.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningbasics3.R
import com.example.learningbasics3.models.Anime
import com.example.learningbasics3.viewModels.AnimeViewModel


@Composable
fun DetailsScreen(){
    val animeViewModel : AnimeViewModel = hiltViewModel()
    val animes = animeViewModel.animeNames.collectAsState()

    LazyColumn(content = {
        items(animes.value){
            DetailsItem(it.text)
        }
    })
}

@Composable
fun DetailsItem(animeName : String){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        , border = BorderStroke(1.dp, color = colorResource(id = R.color.primary))
        , content = {
            Text(text = animeName,
                modifier = Modifier
                    .padding(16.dp)
                    ,style = MaterialTheme.typography.bodyMedium

            )
        }
    )
}