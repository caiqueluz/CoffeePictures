package com.example.coffeepictures

import com.example.coffeepictures.app.app.presentation.AppScreenModel
import com.example.coffeepictures.app.navigator.AppScreenNavigator
import com.example.coffeepictures.app.navigator.AppScreenNavigatorImpl
import kotlinx.coroutines.CoroutineScope
import org.junit.Assert.assertEquals

class FakeAppScreenNavigator(
    private val initialModel: AppScreenModel,
    private val coroutineScope: CoroutineScope,
): AppScreenNavigator by AppScreenNavigatorImpl(
    initialModel = initialModel,
    coroutineScope = coroutineScope,
) {
    fun <ModelT : AppScreenModel> expectCurrentScreenModel(expected: ModelT) {
        val actual = appScreenFlow.value

        assertEquals(
            expected,
            actual,
        )
    }
}
