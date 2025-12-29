package com.example.coffeepictures

import com.example.coffeepictures.app.app.presentation.AppScreenModel
import com.example.coffeepictures.applogic.api.RandomImageModel
import com.example.coffeepictures.core.FakeAppScreenNavigator
import com.example.coffeepictures.core.TestCoroutinesRule
import com.example.coffeepictures.core.applogic.FakeLoadAllFavoriteImagesTask
import com.example.coffeepictures.favorites.presentation.logic.FavoriteImageModel
import com.example.coffeepictures.favorites.presentation.logic.FavoritesViewModel
import com.example.coffeepictures.favorites.presentation.logic.FavoritesViewState
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

// TODO - replace with integration test.
@RunWith(JUnit4::class)
class FavoritesViewModelTest {
    @get:Rule
    val testCoroutinesRule = TestCoroutinesRule()

    private lateinit var fakeNavigator: FakeAppScreenNavigator
    private lateinit var fakeLoadAllFavoriteImagesTask: FakeLoadAllFavoriteImagesTask
    private lateinit var viewModel: FavoritesViewModel

    @Before
    fun before() {
        fakeLoadAllFavoriteImagesTask = FakeLoadAllFavoriteImagesTask()
    }

    @Test
    fun `GIVEN loaded with success AND with non-empty models list WHEN screen has started THEN set correct state`() =
        runTest {
            fakeNavigator = FakeAppScreenNavigator(initialModel = AppScreenModel.Favorites)

            viewModel =
                FavoritesViewModel(
                    loadAllFavoriteImagesTask = fakeLoadAllFavoriteImagesTask,
                    appScreenNavigator = fakeNavigator,
                )

            listOf(
                RandomImageModel(
                    url = "example.com/1.png",
                    isFavorite = false,
                ),
                RandomImageModel(
                    url = "example.com/2.png",
                    isFavorite = false,
                ),
                RandomImageModel(
                    url = "example.com/3.png",
                    isFavorite = false,
                ),
            ).let { result ->
                fakeLoadAllFavoriteImagesTask.fakeSuccess(model = result)
            }

            viewModel.onFavoritesStarted()

            val expected =
                FavoritesViewState(
                    isLoadingVisible = false,
                    isErrorVisible = false,
                    imageModels =
                        listOf(
                            FavoriteImageModel(
                                titleText = "example.com/1.png",
                                url = "example.com/1.png",
                            ),
                            FavoriteImageModel(
                                titleText = "example.com/2.png",
                                url = "example.com/2.png",
                            ),
                            FavoriteImageModel(
                                titleText = "example.com/3.png",
                                url = "example.com/3.png",
                            ),
                        ),
                )

            val actual = viewModel.viewState.value

            assertEquals(
                expected,
                actual,
            )
        }

    @Test
    fun `GIVEN loaded with success AND with empty models list WHEN screen has started THEN set correct state`() =
        runTest {
            fakeNavigator = FakeAppScreenNavigator(initialModel = AppScreenModel.Favorites)

            viewModel =
                FavoritesViewModel(
                    loadAllFavoriteImagesTask = fakeLoadAllFavoriteImagesTask,
                    appScreenNavigator = fakeNavigator,
                )

            fakeLoadAllFavoriteImagesTask
                .fakeSuccess(
                    model = emptyList(),
                )

            viewModel.onFavoritesStarted()

            val expected =
                FavoritesViewState(
                    isLoadingVisible = false,
                    isErrorVisible = true,
                    imageModels = emptyList(),
                )

            val actual = viewModel.viewState.value

            assertEquals(
                expected,
                actual,
            )
        }

    @Test
    fun `GIVEN loaded with error WHEN screen has started THEN set correct state`() =
        runTest {
            fakeNavigator = FakeAppScreenNavigator(initialModel = AppScreenModel.Favorites)

            viewModel =
                FavoritesViewModel(
                    loadAllFavoriteImagesTask = fakeLoadAllFavoriteImagesTask,
                    appScreenNavigator = fakeNavigator,
                )

            fakeLoadAllFavoriteImagesTask
                .fakeFailure(
                    throwable = Exception("Get all images fake error."),
                )

            viewModel.onFavoritesStarted()

            val expected =
                FavoritesViewState(
                    isLoadingVisible = false,
                    isErrorVisible = true,
                    imageModels = emptyList(),
                )

            val actual = viewModel.viewState.value

            assertEquals(
                expected,
                actual,
            )
        }

    @Test
    fun `GIVEN screen has started WHEN back button is clicked THEN navigate back`() =
        runTest {
            fakeNavigator = FakeAppScreenNavigator(initialModel = AppScreenModel.Favorites)

            viewModel =
                FavoritesViewModel(
                    loadAllFavoriteImagesTask = fakeLoadAllFavoriteImagesTask,
                    appScreenNavigator = fakeNavigator,
                )

            fakeLoadAllFavoriteImagesTask
                .fakeSuccess(
                    model = emptyList(),
                )

            viewModel.onFavoritesStarted()
            viewModel.onBackButtonClicked()

            fakeNavigator.expectCurrentScreenModel(expected = AppScreenModel.Home)
        }
}
