package com.example.coffeepictures

import com.example.coffeepictures.app.app.presentation.AppScreenModel
import com.example.coffeepictures.core.FakeAppScreenNavigator
import com.example.coffeepictures.core.FakeImagesDao
import com.example.coffeepictures.core.TestCoroutinesRule
import com.example.coffeepictures.favorites.data.LoadAllFavoriteImagesTaskImpl
import com.example.coffeepictures.favorites.domain.LoadAllFavoriteImagesTask
import com.example.coffeepictures.favorites.presentation.logic.FavoriteImageModel
import com.example.coffeepictures.favorites.presentation.logic.FavoritesViewModel
import com.example.coffeepictures.favorites.presentation.logic.FavoritesViewState
import com.example.coffeepictures.infrastructure.database.api.ImageEntity
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FavoritesViewModelTest {
    @get:Rule
    val testCoroutinesRule = TestCoroutinesRule()

    private lateinit var fakeNavigator: FakeAppScreenNavigator
    private lateinit var fakeImagesDao: FakeImagesDao
    private lateinit var loadAllFavoriteImagesTask: LoadAllFavoriteImagesTask
    private lateinit var viewModel: FavoritesViewModel

    @Before
    fun before() {
        fakeImagesDao = FakeImagesDao()
        loadAllFavoriteImagesTask = LoadAllFavoriteImagesTaskImpl(fakeImagesDao)
    }

    @Test
    fun `GIVEN loaded with success AND with non-empty models list WHEN screen has started THEN set correct state`() =
        runTest {
            fakeNavigator = FakeAppScreenNavigator(initialModel = AppScreenModel.Favorites)

            viewModel =
                FavoritesViewModel(
                    loadAllFavoriteImagesTask = loadAllFavoriteImagesTask,
                    appScreenNavigator = fakeNavigator,
                )

            listOf(
                ImageEntity(url = "example.com/1.png"),
                ImageEntity(url = "example.com/2.png"),
                ImageEntity(url = "example.com/3.png"),
            ).forEach { model ->
                fakeImagesDao.insert(entity = model)
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
                    loadAllFavoriteImagesTask = loadAllFavoriteImagesTask,
                    appScreenNavigator = fakeNavigator,
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
                    loadAllFavoriteImagesTask = loadAllFavoriteImagesTask,
                    appScreenNavigator = fakeNavigator,
                )

            fakeImagesDao.fakeGetAllImagesError()
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
                    loadAllFavoriteImagesTask = loadAllFavoriteImagesTask,
                    appScreenNavigator = fakeNavigator,
                )

            viewModel.onFavoritesStarted()
            viewModel.onBackButtonClicked()

            fakeNavigator.expectCurrentScreenModel(expected = AppScreenModel.Home)
        }
}
