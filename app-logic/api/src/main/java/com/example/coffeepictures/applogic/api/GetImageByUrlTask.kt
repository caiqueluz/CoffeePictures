package com.example.coffeepictures.applogic.api

interface GetImageByUrlTask {
    suspend fun get(url: String): Result<RandomImageModel>
}
