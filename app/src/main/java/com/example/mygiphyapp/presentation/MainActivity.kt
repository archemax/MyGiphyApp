package com.example.mygiphyapp.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.mygiphyapp.presentation.navigation.Navigation
import com.example.mygiphyapp.ui.theme.MyGiphyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGiphyAppTheme {
                Navigation()
                //TestScreen()


            }
        }
    }
}

@Composable
fun HelloThere() {
    Text(text = "hello")
}


