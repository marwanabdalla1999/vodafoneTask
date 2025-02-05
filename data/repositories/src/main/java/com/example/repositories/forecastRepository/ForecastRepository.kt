package com.example.repositories.forecastRepository

import com.example.forcast.models.ForecastResponse
import com.example.forcast.repositoriesDelegation.IForecastRepository
import com.example.network.NetworkHelper
import com.example.repositories.weatherDetailsService.IWeatherDetailsService
import kotlinx.coroutines.flow.flow

internal class ForecastRepository(
    private val forecastService: IWeatherDetailsService,
    private val networkHelper: NetworkHelper
) : IForecastRepository {
    override fun getForecast(latitude: Double, longitude: Double) = flow<ForecastResponse?> {
        val response = networkHelper.processCall<ForecastResponse> {
            forecastService.getForecastDetails(latitude, longitude)
        }
        emit(response)
    }

}