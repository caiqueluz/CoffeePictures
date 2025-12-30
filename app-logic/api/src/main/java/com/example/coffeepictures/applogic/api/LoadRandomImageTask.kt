package com.example.coffeepictures.applogic.api

interface LoadRandomImageTask {
    suspend operator fun invoke(): Result<ImageModel>
}
