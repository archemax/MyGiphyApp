package com.example.mygiphyapp.presentation

import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.OriginalSize
import com.example.mygiphyapp.R

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()

) {
    val state = viewModel.state.value
    Log.d("ABC", "$state")

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "gifs")
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.myGifs) { oneGif ->
                GifImage(url = oneGif.myUrl)
                Log.d("links", oneGif.myUrl)

            }
        }
    }

}
@Composable
fun GifImage(url: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
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
        Log.d("imageloader", "$imageLoader")

        AsyncImage(
            model =  url,
            imageLoader = imageLoader,
            contentDescription = "",
            modifier = Modifier
                .padding(8.dp)
                .clip(MaterialTheme.shapes.medium)
        )
    }



}







