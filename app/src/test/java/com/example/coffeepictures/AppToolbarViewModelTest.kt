package com.example.coffeepictures

import com.example.coffeepictures.app.app.presentation.AppScreenModel
import com.example.coffeepictures.apptoolbar.presentation.logic.AppToolbarActionModel
import com.example.coffeepictures.apptoolbar.presentation.logic.AppToolbarViewModel
import com.example.coffeepictures.apptoolbar.presentation.logic.AppToolbarViewState
import com.example.coffeepictures.core.FakeAppScreenNavigator
import com.example.coffeepictures.core.TestCoroutinesRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

// TODO - replace with integration test.
@RunWith(JUnit4::class)
class AppToolbarViewModelTest {
    @get:Rule
    val testCoroutinesRule = TestCoroutinesRule()

    private lateinit var fakeNavigator: FakeAppScreenNavigator
    private lateinit var viewModel: AppToolbarViewModel

    @Test
    fun `GIVEN Home screen model THEN set correct view state`() =
        runTest {
            fakeNavigator = FakeAppScreenNavigator(initialModel = AppScreenModel.Home)
            viewModel = AppToolbarViewModel(appScreenNavigator = fakeNavigator)

            val expected =
                AppToolbarViewState(
                    isBackIconVisible = false,
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
                    isBackIconVisible = true,
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
