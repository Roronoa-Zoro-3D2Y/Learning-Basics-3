package com.example.learningbasics3.screens

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learningbasics3.R
import com.example.learningbasics3.viewModels.CategoryViewModel


@Composable
fun CategoryScreen(onClickDo:(category:String) -> Unit) {
    //the func viewmodel() is responsible for getting an obj of the viewmodel nd assigning it to
    //wherever it is called
    val categoryViewModel : CategoryViewModel = hiltViewModel()
    val categories: State<List<String>> = categoryViewModel.categories.collectAsState()

    Log.d("10101010", "CategoryScreen: ")
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround,

       ) {
        items(categories.value.distinct()){
            Log.d("10101010", "CategoryScreen ")

            CategoryItem(category = it, onClickDo)
        }
    }
}

@Composable
fun CategoryItem(category:String,onClickDo:(category:String) -> Unit) {

          Box(modifier = Modifier
              .padding(4.dp)
              .size(160.dp)
              .clip(RoundedCornerShape(10.dp))
              .border(width = 1.dp, colorResource(id = R.color.box_border))
              .paint(
                  painter = painterResource(id = R.drawable.wave_bg),
                  contentScale = ContentScale.Crop
              )
              .clickable {
                  onClickDo(category)
              },
              contentAlignment = Alignment.BottomCenter
         )  {

              Text(text = category
                  , fontSize = 20.sp
                  , fontStyle = FontStyle.Normal
                  , fontWeight = FontWeight.ExtraBold
                  , color = colorResource(id = R.color.textColor)
                  , textDecoration = TextDecoration.None
                  , modifier = Modifier
                      .padding(0.dp, 20.dp)
                      .size(width = 100.dp, height = 60.dp)
                  , style = TextStyle(shadow = Shadow(colorResource(id = R.color.text_border), offset = Offset(5.0f, 4.0f), blurRadius = 20f))
                  , textAlign = TextAlign.Center
              )
                 
          }
}