package com.example.forecast

import app.cash.turbine.test
import com.example.forcast.models.City
import com.example.forcast.models.Coord
import com.example.forcast.models.ForecastResponse
import com.example.forcast.usecase.getForecastListingUseCase.IGetForecastListingUseCase
import com.example.forecast.screens.forcastScreen.ForecastEvent
import com.example.forecast.screens.forcastScreen.ForecastSideEffect
import com.example.forecast.screens.forcastScreen.ForecastState
import com.example.forecast.screens.forcastScreen.ForecastViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ForecastViewModelTest {
    private lateinit var viewModel: ForecastViewModel
    private val mockUseCase: IGetForecastListingUseCase = mockk()
    private val testDispatcher = kotlinx.coroutines.test.UnconfinedTestDispatcher()
    private val testForecast = ForecastResponse(city = City(coord = Coord(lat = 0.0, lon = 0.0), country = "London", id = 0, name = "", population = 0, sunrise = 0, sunset = 0, timezone = 0), list = persistentListOf(), cnt = 0, cod = "", message = 0)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = ForecastViewModel(mockUseCase)
    }

    @Test
    fun `initial state should be Ideal`(): Unit = runTest {
        assertEquals(ForecastState.Ideal, viewModel.viewState.value)
    }

    @Test
    fun `when getting forecast successfully, should update state correctly`() = runTest {
        // Given
        coEvery { mockUseCase(any(), any()) } returns flow { emit(testForecast) }

        // When
        viewModel.setEvent(ForecastEvent.OnGetForecast(0.0, 0.0))

        // Then
        viewModel.viewState.test {
            assertTrue(awaitItem() is ForecastState.Success)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `should call use case with correct coordinates`() = runTest {
        // Given
        val testLat = 40.7128
        val testLon = -74.0060
        coEvery { mockUseCase(testLat, testLon) } returns flow { emit(testForecast) }

        // When
        viewModel.setEvent(ForecastEvent.OnGetForecast(testLat, testLon))

        // Then
        viewModel.viewState.test {
            awaitItem() // Success
        }
    }
}