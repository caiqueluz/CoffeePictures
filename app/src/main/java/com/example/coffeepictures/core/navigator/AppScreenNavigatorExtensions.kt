package com.example.coffeepictures.core.navigator

import com.example.coffeepictures.app.app.presentation.AppScreenModel

fun AppScreenNavigator.currentModel(): AppScreenModel {
    return this
        .appScreenFlow
        .value
}
