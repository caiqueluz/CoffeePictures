package com.example.coffeepictures.app.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.coffeepictures.app.app.presentation.AppScreenModel

@Composable
fun rememberAppScreenNavigator(initialModel: AppScreenModel): AppScreenNavigator {
    val coroutineScope = rememberCoroutineScope()

    return remember {
        AppScreenNavigatorImpl(
            initialModel = initialModel,
            coroutineScope = coroutineScope,
        )
    }
}
