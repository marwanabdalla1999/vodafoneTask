package com.example.forcast.usecase.getForecastListingUseCase

import com.example.forcast.models.ForecastResponse
import kotlinx.coroutines.flow.Flow

interface IGetForecastListingUseCase {
    operator fun invoke(latitude: Double, longitude: Double): Flow<ForecastResponse?>
}