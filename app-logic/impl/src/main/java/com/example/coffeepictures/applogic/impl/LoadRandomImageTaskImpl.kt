package com.example.coffeepictures.applogic.impl

import com.example.coffeepictures.applogic.api.LoadRandomImageTask
import com.example.coffeepictures.applogic.api.ImageModel

class LoadRandomImageTaskImpl(
    private val httpClient: ImagesHttpClient,
) : LoadRandomImageTask {
    override suspend operator fun invoke(): Result<ImageModel> {
        return httpClient.loadRandomImage()
            .map { response ->
                ImageModel(
                    url = response.url,
                    isFavorite = false,
                )
            }
    }
}
