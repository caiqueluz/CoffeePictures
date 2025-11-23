package com.example.coffeepictures

import org.koin.core.module.Module
import org.koin.dsl.module

fun compositeModule(vararg modules: Module): Module {
    return module {
        includes(modules.toList())
    }
}
