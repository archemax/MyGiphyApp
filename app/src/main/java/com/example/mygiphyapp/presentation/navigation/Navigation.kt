package com.example.mygiphyapp.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mygiphyapp.presentation.MainScreen
import com.example.mygiphyapp.presentation.OneGifScreen
import java.net.URLEncoder

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun Navigation() {
    val navController = rememberNavController()

    val toOneGifScreen = { gifLink: String ->
        val encodedGifLink = URLEncoder.encode(gifLink, "UTF-8")
        navController.navigate("ONE_GIF_SCREEN/$encodedGifLink")
    }


    NavHost(
        navController = navController,
        startDestination = Screen.MAIN_SCREEN.name
    ) {

        composable(
            route = Screen.MAIN_SCREEN.name
        ) {
            MainScreen(
                toOneGifScreen = toOneGifScreen,
                navController = navController
            )
        }

        composable(
            route = "${Screen.ONE_GIF_SCREEN.name}/{gifLink}",
            arguments = listOf(navArgument("gifLink"){type = NavType.StringType})
        ){ backStackEntry ->
            val gifLink = backStackEntry.arguments?.getString("gifLink")
            OneGifScreen(gifLink = gifLink, navController = navController)
        }


    }
}

enum class Screen {
    MAIN_SCREEN,
    ONE_GIF_SCREEN,

}