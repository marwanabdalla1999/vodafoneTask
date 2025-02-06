package com.example.forecast.screens.forcastScreen.di

import com.example.network.NetworkHelper
import com.example.repositories.forecastRepository.ForecastRepository
import com.example.repositories.weatherDetailsService.IWeatherDetailsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {
    @Provides
    fun provideForecastDetailsRepository(
        forecastDetailsService: IWeatherDetailsService,
        networkHelper: NetworkHelper
    ) = ForecastRepository(forecastDetailsService, networkHelper)

}