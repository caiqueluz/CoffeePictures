package com.example.coffeepictures

import kotlinx.coroutines.CoroutineScope

interface AppDependencies {
    val appCoroutineScope: CoroutineScope
}
