package com.example.coffeepictures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.coffeepictures.app.presentation.App
import com.example.coffeepictures.core.setCoffeePicturesContent

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setCoffeePicturesContent {
            App(
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
