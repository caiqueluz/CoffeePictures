package com.example.coffeepictures.applogic.api

interface GetImageByUrlTask {
    suspend operator fun invoke(url: String): Result<ImageModel>
}
