package com.example.coffeepictures.applogic.api

interface DeleteFavoriteByUrlTask {
    suspend operator fun invoke(url: String): Result<Unit>
}
