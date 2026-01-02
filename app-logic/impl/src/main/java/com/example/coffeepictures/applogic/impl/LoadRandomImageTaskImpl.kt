package com.example.coffeepictures.applogic.impl

import com.example.coffeepictures.applogic.api.ImageModel
import com.example.coffeepictures.applogic.api.LoadRandomImageTask
import com.example.coffeepictures.infrastructure.network.api.requireBody

class LoadRandomImageTaskImpl(
    private val httpClient: ImagesRetrofitClient,
) : LoadRandomImageTask {
    override suspend operator fun invoke(): Result<ImageModel> {
        return runCatching {
            val response = httpClient.loadRandomImage()
            val body = response.requireBody()

            ImageModel(
                url = body.url,
                isFavorite = false,
            )
        }
    }
}
