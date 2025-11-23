package com.example.coffeepictures.home.data

import com.example.coffeepictures.home.domain.LoadRandomImageTask
import com.example.coffeepictures.home.domain.RandomImageModel

class LoadRandomImageTaskImpl(
    private val httpClient: RandomImagesHttpClient,
) : LoadRandomImageTask {
    override suspend fun load(): Result<RandomImageModel> {
        return httpClient.loadRandomImage()
            .map { response ->
                RandomImageModel(
                    url = response.url,
                )
            }
    }
}
