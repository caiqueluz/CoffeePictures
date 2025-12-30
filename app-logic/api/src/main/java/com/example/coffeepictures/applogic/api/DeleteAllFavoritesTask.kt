package com.example.coffeepictures.applogic.api

interface DeleteAllFavoritesTask {
    suspend operator fun invoke(): Result<Unit>
}
