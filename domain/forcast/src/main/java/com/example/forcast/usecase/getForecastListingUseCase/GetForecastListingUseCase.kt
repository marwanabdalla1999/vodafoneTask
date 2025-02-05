package com.example.forcast.usecase.getForecastListingUseCase

import com.example.forcast.repositoriesDelegation.IForecastRepository

class GetForecastListingUseCase(private val forecastRepository: IForecastRepository) :
    IGetForecastListingUseCase {
    override operator fun invoke(latitude: Double, longitude: Double) =
        forecastRepository.getForecast(latitude = latitude, longitude = longitude)
}