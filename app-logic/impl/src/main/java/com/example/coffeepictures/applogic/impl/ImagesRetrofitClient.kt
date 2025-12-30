package com.example.coffeepictures.applogic.impl

import retrofit2.Response
import retrofit2.http.GET

interface ImagesRetrofitClient {
    @GET("/random.json")
    suspend fun loadRandomImage(): Response<ImageResponse>
}
