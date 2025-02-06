package com.example.repositories.diModules

import com.example.cashing.DataStoreManager
import com.example.repositories.cashingService.CashingService
import com.example.repositories.cashingService.ICashingService
import com.example.repositories.searchForWeatherService.ISearchForWeatherService
import com.example.repositories.searchForWeatherService.SearchForWeatherService
import com.example.repositories.weatherDetailsService.IWeatherDetailsService
import com.example.repositories.weatherDetailsService.WeatherDetailsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {

    @Provides
    fun provideSearchForWeatherService(client: HttpClient): ISearchForWeatherService {
        return SearchForWeatherService(client)
    }

    @Provides
    fun provideWeatherDetailsService(client: HttpClient): IWeatherDetailsService {
        return WeatherDetailsService(client)
    }

    @Provides
    fun provideCashingService(dataStoreManager: DataStoreManager): ICashingService {
        return CashingService(dataStoreManager)
    }
}