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
        model = "https://media0.giphy.com/media/3o7527pa7qs9kCG78A/giphy.gif?cid=5da11ca9tqevf4ucjmgxl91c2xpehfdjtht7qr0vl6xs7woo&ep=v1_gifs_search&rid=giphy.gif&ct=g",
        imageLoader = imageLoader,
        contentDescription = "",
        modifier = Modifier.fillMaxSize()
    )
}
