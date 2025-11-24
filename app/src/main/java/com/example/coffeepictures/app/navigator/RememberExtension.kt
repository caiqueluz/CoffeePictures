package com.example.coffeepictures.app.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.coffeepictures.app.app.presentation.AppScreenModel

@Composable
fun rememberAppScreenNavigator(initialModel: AppScreenModel): AppScreenNavigator {
    return remember {
        AppScreenNavigatorImpl(
            initialModel = initialModel,
        )
    }
}
