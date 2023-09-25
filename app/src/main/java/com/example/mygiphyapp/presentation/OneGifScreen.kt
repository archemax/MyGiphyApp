package com.example.mygiphyapp.presentation

import android.os.Build
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import java.net.URLDecoder

@Composable
fun OneGifScreen(
    navController: NavController,
    gifLink: String?

) {

    Text(text = "OneGifScreen")
    Column(modifier = Modifier.fillMaxSize()) {
        val decodedGifLink = URLDecoder.decode(gifLink, "UTF-8")



        val context = LocalContext.current
        val imageLoader = ImageLoader.Builder(context)

            .components {
                if (Build.VERSION.SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()
        Log.d("imageloadertest", "$imageLoader")

        AsyncImage(
            model = decodedGifLink,
            imageLoader = imageLoader,
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )

    }
}