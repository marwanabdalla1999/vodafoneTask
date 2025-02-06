package com.example.vodafonetask.di

import com.example.forcast.repositoriesDelegation.IForecastRepository
import com.example.network.NetworkHelper
import com.example.repositories.cashingRepository.CashingRepository
import com.example.repositories.cashingService.ICashingService
import com.example.repositories.forecastRepository.ForecastRepository
import com.example.repositories.searchForWeatherRepository.SearchForWeatherRepository
import com.example.repositories.searchForWeatherService.ISearchForWeatherService
import com.example.repositories.weatherDetailsService.IWeatherDetailsService
import com.example.searchforweather.repositories.ICashingRepository
import com.example.searchforweather.repositories.ISearchForWeatherRepository
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

    @Provides
    fun provideSearchForWeatherRepository(
        searchForWeatherService: ISearchForWeatherService,
        networkHelper: NetworkHelper
    ): ISearchForWeatherRepository {
        return SearchForWeatherRepository(searchForWeatherService, networkHelper)
    }

    @Provides
    fun provideCashingRepository(cashingService: ICashingService): ICashingRepository =
        CashingRepository(cashingService)

}