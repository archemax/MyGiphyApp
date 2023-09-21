package com.example.mygiphyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.mygiphyapp.ui.theme.MyGiphyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGiphyAppTheme {
HelloThere()

            }
        }
    }
}
@Composable
fun HelloThere (){
    Text(text = "hello")
}


