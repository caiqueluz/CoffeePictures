package com.example.coffeepictures.core

import com.example.coffeepictures.app.app.presentation.AppScreenModel
import com.example.coffeepictures.core.navigator.AppScreenNavigator
import com.example.coffeepictures.core.navigator.AppScreenNavigatorImpl
import org.junit.Assert.assertEquals

class FakeAppScreenNavigator(
    private val initialModel: AppScreenModel,
): AppScreenNavigator by AppScreenNavigatorImpl(
    initialModel = initialModel,
) {
    fun <ModelT : AppScreenModel> expectCurrentScreenModel(expected: ModelT) {
        val actual = appScreenFlow.value

        assertEquals(
            expected,
            actual,
        )
    }
}
