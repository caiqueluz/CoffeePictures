package com.example.coffeepictures

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.coffeepictures.designsystem.core.CoffeePicturesTheme
import org.koin.core.module.Module
import org.koin.dsl.module

val ComponentActivity.coffeePicturesApplication: CoffeePicturesApplication
    get() {
        return application as CoffeePicturesApplication
    }

fun ComponentActivity.setCoffeePicturesContent(
    content: @Composable () -> Unit,
) {
    setContent {
        CoffeePicturesTheme(
            content = content,
        )
    }
}

fun compositeModule(vararg modules: Module): Module {
    return module {
        includes(modules.toList())
    }
}
