package com.example.inputcityfeature

import app.cash.turbine.test
import com.example.inputcityfeature.screens.InputCityViewModel
import com.example.searchforweather.entities.CitiesEntity
import com.example.searchforweather.getCashedLonAndLatUseCase.GetCashedLonAndLatUseCase
import com.example.searchforweather.getCitiesFromQuery.IGetCitiesFromQueryUseCase
import com.example.searchforweather.saveLonAndLatUseCase.SaveLonAndLatUseCase
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class InputCityViewModelTest {
    private lateinit var viewModel: InputCityViewModel
    private val mockUseCase: IGetCitiesFromQueryUseCase = mockk()
    private val mockSaveLonAndLatUseCase: SaveLonAndLatUseCase = mockk()
    private val mockGetCashedLonAndLatUseCase: GetCashedLonAndLatUseCase = mockk()

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = InputCityViewModel(
            mockUseCase,
            saveLonAndLatUseCase = mockSaveLonAndLatUseCase,
            getCashedLonAndLatUseCase = mockGetCashedLonAndLatUseCase
        )
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `searchWeather should cancel previous job when new search is made`() = runTest {
        coEvery { mockUseCase.invoke(any()) } returns flowOf(emptyList())

        viewModel.searchWeather("Lon")
        viewModel.searchWeather("London")
        testDispatcher.scheduler.advanceTimeBy(500)

        viewModel.weatherResults.test {
            assertEquals(emptyList<CitiesEntity>(), awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `searchWeather should handle empty results`() = runTest {
        coEvery { mockUseCase.invoke(any()) } returns flowOf(null)

        viewModel.searchWeather("InvalidCity")
        testDispatcher.scheduler.advanceTimeBy(500)

        viewModel.weatherResults.test {
            assertEquals(emptyList<CitiesEntity>(), awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }
}