package com.example.mygiphyapp.presentation

import android.os.Build
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder

@Composable
fun TestScreen() {
    Text(text = "test screen")


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
        model = "https://giphy.com/gifs/cat-funny-animation-aC45M5Q4D07Pq",
        imageLoader = imageLoader,
        contentDescription = "",
        modifier = Modifier.fillMaxSize()
    )
}
