package com.example.repositories

import app.cash.turbine.test
import com.example.network.NetworkHelper
import com.example.repositories.searchForWeatherRepository.SearchForWeatherRepository
import com.example.repositories.searchForWeatherService.ISearchForWeatherService
import com.example.searchforweather.entities.CitiesEntity
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
class SearchForWeatherRepositoryTest {
    private lateinit var repository: SearchForWeatherRepository
    private val mockService: ISearchForWeatherService = mockk()
    private val mockNetworkHelper: NetworkHelper = mockk()
    private val testDispatcher = kotlinx.coroutines.test.UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = SearchForWeatherRepository(mockService, mockNetworkHelper)
    }

    @Test
    fun `searchForWeather SHOULD use network helper WHEN called`() = runTest {
        coEvery { mockNetworkHelper.processCall<List<CitiesEntity>>(any()) } returns emptyList()

        repository.searchForWeather("test").first()

        coVerify(exactly = 1) { mockNetworkHelper.processCall<List<CitiesEntity>>(any()) }
    }

    @Test
    fun `searchForWeather SHOULD emit SUCCESS data WHEN network call succeeds`() = runTest {
        val expectedCities = listOf(
            CitiesEntity(name = "London", lat = "51.5074", lon = "0.1278", country = "GB", state = "Greater London"),
            CitiesEntity(name = "Paris", lat = "48.8566", lon = "2.3522", country = "FR", state = "Île-de-France")
        )
        coEvery { mockNetworkHelper.processCall<List<CitiesEntity>>(any()) } returns expectedCities

        repository.searchForWeather("test").test {
            assertEquals(expectedCities, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `searchForWeather SHOULD emit NULL WHEN network returns empty`() = runTest {
        coEvery { mockNetworkHelper.processCall<List<CitiesEntity>>(any()) } returns null

        repository.searchForWeather("test").test {
            assertEquals(null, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `searchForWeather SHOULD propagate NETWORK errors WHEN call fails`() = runTest {
        val expectedError = IOException("Network failure")
        coEvery { mockNetworkHelper.processCall<List<CitiesEntity>>(any()) } throws expectedError

        repository.searchForWeather("test").test {
            val error = awaitError()
            assertTrue(error is IOException)
            assertEquals("Network failure", error.message)
        }
    }

    @Test
    fun `searchForWeather SHOULD handle EMPTY query CORRECTLY`() = runTest {
        val emptyQuery = ""
        coEvery { mockNetworkHelper.processCall<List<CitiesEntity>>(any()) } returns emptyList()

        repository.searchForWeather(emptyQuery).test {
            assertEquals(emptyList<CitiesEntity>(), awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `searchForWeather SHOULD handle SPECIAL characters IN query`() = runTest {
        val testQuery = "São Paulo"
        coEvery { mockNetworkHelper.processCall<List<CitiesEntity>>(any()) } returns listOf(
            CitiesEntity(name = "São Paulo", lat = "-23.5505", lon = "-46.6333", country = "BR", state = "São Paulo")
        )

        repository.searchForWeather(testQuery).test {
            val result = awaitItem()
            assertEquals("São Paulo", result?.first()?.name)
            cancelAndIgnoreRemainingEvents()
        }
    }
}