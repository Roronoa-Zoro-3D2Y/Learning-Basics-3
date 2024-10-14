package com.example.learningbasics3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.AnimeApi
import com.example.Nav.AppNav
import com.example.learningbasics3.screens.CategoryScreen
import com.example.learningbasics3.screens.DetailsScreen
import com.ui.theme.LearningBasics3Theme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var animeApi: AnimeApi

    @OptIn(DelicateCoroutinesApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*GlobalScope.launch {
            val response = animeApi.getCategory()
            val result = response.body()

            if (result != null) {
                Log.d("MainActivity", "My Animes"+result.distinct().toString())
            }
        }*/
        setContent {
                LearningBasics3Theme {
                        Scaffold(topBar = {
                            TopAppBar(
                                title = {
                                    Text(text = "Anime Top Moments!!!",
                                        color = colorResource(id = R.color.waveBg))
                                })
                        }) {
                            Box(modifier = Modifier
                                .padding(it)
                                .fillMaxSize()
                                .background(colorResource(id = R.color.primary))){
                                NavApp()
                            }
                        }
                }
        }
    }
}
@Composable
fun NavApp(){
    val navController  = rememberNavController()
    NavHost(navController = navController, startDestination = "category" ){
        composable(route = "category"){
            CategoryScreen {
                //we r getting category of String type from where the category composable is being called
                //so less pass the string to the details screen
                navController.navigate("details/${it}")
            }
        }

        composable(route = "details/{categoryName}",
            arguments = listOf(navArgument("categoryName"){
                type = NavType.StringType
            })
        ){
            DetailsScreen()
        }
        composable(route = "registration"){
            RegistrationScreen()
        }
    }
}
@Composable
fun RegistrationScreen(){
    Text(text = "Registration Screen",
        style = MaterialTheme.typography.displayLarge,
        modifier = Modifier

            .background(color = colorResource(id = R.color.primary)),
        textAlign = TextAlign.Center
    )
}
