package com.example.coffeepictures.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberAppScreenNavigator(initialModel: AppScreenModel): AppScreenNavigator {
    return remember {
        AppScreenNavigatorImpl(
            initialModel = initialModel,
        )
    }
}
