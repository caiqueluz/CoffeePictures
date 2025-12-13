package com.example.coffeepictures.image

import android.content.Context
import coil3.ImageLoader
import coil3.network.NetworkFetcher
import coil3.network.okhttp.OkHttpNetworkFetcherFactory
import com.example.coffeepictures.infrastructure.network.api.OkHttpClientFactory

class CoilImageLoaderFactory(
    private val applicationContext: Context,
    private val okHttpClientFactory: OkHttpClientFactory,
) {
    private val networkFetcherFactory by lazy {
        createNetworkFetcherFactory()
    }

    fun create(): ImageLoader {
        return ImageLoader.Builder(applicationContext)
            .components {
                add(networkFetcherFactory)
            }
            .build()
    }

    private fun createNetworkFetcherFactory(): NetworkFetcher.Factory {
        return OkHttpNetworkFetcherFactory(
            callFactory = {
                okHttpClientFactory.create()
            },
        )
    }
}
