package com.example.coffeepictures.applogic.impl

import com.example.coffeepictures.applogic.api.LoadRandomImageTask
import com.example.coffeepictures.applogic.api.RandomImageModel

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
