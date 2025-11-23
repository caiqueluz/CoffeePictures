package com.example.coffeepictures.app.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

@Composable
fun rememberAppScreenNavigator(): AppScreenNavigator {
    val coroutineScope = rememberCoroutineScope()

    return remember {
        AppScreenNavigatorImpl(
            coroutineScope = coroutineScope,
        )
    }
}
