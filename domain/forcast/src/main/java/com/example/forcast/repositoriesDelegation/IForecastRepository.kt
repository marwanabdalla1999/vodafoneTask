package com.example.forcast.repositoriesDelegation

import com.example.forcast.models.ForecastResponse
import kotlinx.coroutines.flow.Flow

interface IForecastRepository {
    fun getForecast(latitude: Double, longitude: Double): Flow<ForecastResponse?>
}