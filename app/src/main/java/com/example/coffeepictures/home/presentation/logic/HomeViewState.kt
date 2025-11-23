package com.example.coffeepictures.home.presentation.logic

data class HomeViewState(
    val isLoadingVisible: Boolean,
    val isErrorVisible: Boolean,
    val imageUrl: String?,
)
