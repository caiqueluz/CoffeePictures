package com.example.coffeepictures.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BasicViewModel<ViewStateT> : ViewModel() {
    private val mutableViewState by lazy {
        MutableStateFlow(
            value = createViewState(),
        )
    }

    val viewState by lazy {
        mutableViewState.asStateFlow()
    }

    protected fun updateViewState() {
        mutableViewState.update {
            createViewState()
        }
    }

    protected abstract fun createViewState(): ViewStateT
}
