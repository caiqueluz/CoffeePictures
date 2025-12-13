package com.example.coffeepictures.infrastructure.impl

import android.content.Context
import coil3.ImageLoader
import coil3.network.NetworkFetcher
import coil3.network.okhttp.OkHttpNetworkFetcherFactory
import com.example.coffeepictures.infrastructure.api.CoilImageLoaderFactory
import com.example.coffeepictures.infrastructure.network.api.OkHttpClientFactory

class CoilImageLoaderFactoryImpl(
    private val applicationContext: Context,
    private val okHttpClientFactory: OkHttpClientFactory,
) : CoilImageLoaderFactory {
    private val networkFetcherFactory by lazy {
        createNetworkFetcherFactory()
    }

    override fun create(): ImageLoader {
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
