package com.example.coffeepictures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import coil3.compose.setSingletonImageLoaderFactory
import com.example.coffeepictures.app.app.di.appModule
import com.example.coffeepictures.app.App
import com.example.coffeepictures.commonui.impl.rememberFeedbackMessagePresenter
import com.example.coffeepictures.core.setCoffeePicturesContent
import com.example.coffeepictures.infrastructure.api.CoilImageLoaderFactory
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setCoffeePicturesContent {
            val snackbarHostState =
                remember {
                    SnackbarHostState()
                }

            val feedbackMessagePresenter =
                rememberFeedbackMessagePresenter(
                    state = snackbarHostState,
                    getTextValue = ::getString,
                )

            App(
                modifier = Modifier.fillMaxSize(),
                koinAppDeclaration = {
                    androidContext(applicationContext)

                    modules(
                        appModule(feedbackMessagePresenter),
                    )
                },
                configureCoil = ::configureCoil,
                snackbarHostState = snackbarHostState,
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
