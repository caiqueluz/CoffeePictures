package com.example.coffeepictures.infrastructure.api

import coil3.ImageLoader

interface CoilImageLoaderFactory {
    fun create(): ImageLoader
}
