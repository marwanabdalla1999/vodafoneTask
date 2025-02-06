package com.example.forecast.di

import com.example.forcast.repositoriesDelegation.IForecastRepository
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
    ): IForecastRepository = ForecastRepository(forecastDetailsService, networkHelper)

}