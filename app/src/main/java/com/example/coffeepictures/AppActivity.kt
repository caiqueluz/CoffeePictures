package com.example.coffeepictures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.setSingletonImageLoaderFactory
import com.example.coffeepictures.infrastructure.api.CoilImageLoaderFactory
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setCoffeePicturesContent {
            App(
                modifier = Modifier.fillMaxSize(),
                koinAppDeclaration = {
                    androidContext(applicationContext)

                    modules(
                        appModule(coffeePicturesApplication.appDependencies),
                    )
                },
                configureCoil = ::configureCoil,
                getTextValue = ::getString,
            )
        }
    }

    @Composable
    private fun configureCoil() {
        setSingletonImageLoaderFactory {
            val coilImageLoaderFactory = get<CoilImageLoaderFactory>()
            coilImageLoaderFactory.create()
        }
    }
}
