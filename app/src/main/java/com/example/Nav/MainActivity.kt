package com.example.Nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.learningbasics3.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNav()
        }
    }
}



@Composable
fun AppNav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "sender"){
        composable(route = "second/{urName}", arguments =
        listOf( navArgument("urName"){
            type = NavType.StringType
        })

        ){
           val name =  it.arguments?.getString("urName")
            if (name != null) {
                SecondScreen(name)
            }
        }

        composable(route = "registration"){
            RegistrationScreen(navController)
        }
        composable(route = "login"){
            LoginScreen{
                navController.navigate("main")
            }
        }
        composable(route = "main"){
            MainScreen{
                navController.navigate("second/$it")
            }
        }

        //Sender
        composable(route = "sender"){
            SenderScreen{
                navController.navigate("receiver/$it")
            }
        }
        //receiver
        composable(route = "receiver/{senderMsg}",
            arguments = listOf(navArgument("senderMsg"){
                type = NavType.StringType
            })
        ){
            val senderMsg = it.arguments?.getString("senderMsg")
            if (senderMsg != null) {
                ReceiverScreen(senderMsg = senderMsg )
            }
        }
    }

}


@Composable
fun makeBox(text : String,onClickDo: (name:String) -> Unit){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = colorResource(id = R.color.primary))
        ,
        contentAlignment = Alignment.Center,
        content = {
            Text(text = text,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClickDo("You are Beautiful")
                    }
                ,
                color = Color.Black,
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center,

                )
            Text(text = "Click Above",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(50.dp),
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.textColor)
            )
        }
    )
}


@Composable
fun makeBox(text : String){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = colorResource(id = R.color.primary))
        ,
        contentAlignment = Alignment.Center,
        content = {
            Text(text = text,
                modifier = Modifier
                    .fillMaxWidth()
                ,
                color = Color.Black,
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center,

                )
            Text(text = "Click Above",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(50.dp),
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.textColor)
            )
        }
    )
}

@Composable
fun RegistrationScreen(navController: NavController){
    Text(text = "Registration Screen",
        style = MaterialTheme.typography.displayLarge,
        modifier = Modifier
            .clickable {
                navController.navigate("main")
            }
            .background(color = colorResource(id = R.color.primary)),
        textAlign = TextAlign.Center
        )
}

@Composable
fun LoginScreen(onClickDo: () -> Unit){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = colorResource(id = R.color.primary))
        ,
        contentAlignment = Alignment.Center,
        content = {
            Text(text = "Login Screen",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClickDo()
                    }
                ,
                color = Color.Black,
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center,

            )
            Text(text = "Click Above",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(50.dp),
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.textColor)
            )
        }
    )

}

@Composable
fun MainScreen(onClickDo: (name : String) -> Unit){
    /*Text(text = "Main Screen",
        Modifier
            .clickable {
                onClickDo()
            }
            .background(color = colorResource(id = R.color.primary))
            .fillMaxWidth()
            .fillMaxHeight()
        ,
        style = MaterialTheme.typography.displayLarge,
        color = colorResource(id = R.color.textColor2),
*/
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = colorResource(id = R.color.primary))
        ,
        contentAlignment = Alignment.Center,
        content = {
            Text(text = "Main Screen",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClickDo("Nanda Su")
                    }
                ,
                color = Color.Black,
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center,

                )
            Text(text = "Click Above",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(50.dp),
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.textColor)
            )
        }
    )
}

@Composable
fun SecondScreen(name: String){
   /*
    Text(text = "Second Screen - $name",
        style = MaterialTheme.typography.displayLarge,
        modifier = Modifier.background(color = colorResource(id = R.color.primary)),
        color = colorResource(id = R.color.textColor2)
    )*/
    makeBox(text = "Second Screen - $name")
}

@Composable
fun SenderScreen(onClickDo: (name:String) -> Unit){
    makeBox(text = "Sender Screen ",onClickDo)
}

@Composable
fun ReceiverScreen(senderMsg : String){
    makeBox(text = " Receiver Screen received :- \n $senderMsg")
}
