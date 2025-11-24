package com.example.coffeepictures

import com.example.coffeepictures.app.app.presentation.AppScreenModel
import com.example.coffeepictures.app.apptoolbar.presentation.logic.AppToolbarActionModel
import com.example.coffeepictures.app.apptoolbar.presentation.logic.AppToolbarViewModel
import com.example.coffeepictures.app.apptoolbar.presentation.logic.AppToolbarViewState
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AppToolbarViewModelTest {
    private lateinit var fakeNavigator: FakeAppScreenNavigator
    private lateinit var viewModel: AppToolbarViewModel

    @Test
    fun `GIVEN Home screen model THEN set correct view state`() =
        runTest {
            fakeNavigator = FakeAppScreenNavigator(initialModel = AppScreenModel.Home)
            viewModel = AppToolbarViewModel(appScreenNavigator = fakeNavigator)

            val expected =
                AppToolbarViewState(
                    titleTextResId = R.string.home_toolbar_title_text,
                    actionModels =
                        listOf(
                            AppToolbarActionModel.FAVORITES,
                        ),
                )

            val actual = viewModel.viewState.value

            assertEquals(
                expected,
                actual,
            )
        }

    @Test
    fun `GIVEN Favorites screen model THEN set correct view state`() =
        runTest {
            fakeNavigator = FakeAppScreenNavigator(initialModel = AppScreenModel.Favorites)
            viewModel = AppToolbarViewModel(appScreenNavigator = fakeNavigator)

            val expected =
                AppToolbarViewState(
                    titleTextResId = R.string.favorites_toolbar_title_text,
                    actionModels = emptyList(),
                )

            val actual = viewModel.viewState.value

            assertEquals(
                expected,
                actual,
            )
        }

    @Test
    fun `GIVEN Home screen model WHEN first toolbar action icon is clicked THEN navigate to favorites`() =
        runTest {
            fakeNavigator = FakeAppScreenNavigator(initialModel = AppScreenModel.Home)

            viewModel = AppToolbarViewModel(appScreenNavigator = fakeNavigator)
            viewModel.onToolbarActionIconClicked(index = 0)

            fakeNavigator.expectCurrentScreenModel(expected = AppScreenModel.Favorites)
        }
}
