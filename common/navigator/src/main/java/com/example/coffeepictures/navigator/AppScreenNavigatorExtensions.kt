package com.example.coffeepictures.navigator

fun AppScreenNavigator.currentModel(): AppScreenModel {
    return this
        .appScreenFlow
        .value
}
