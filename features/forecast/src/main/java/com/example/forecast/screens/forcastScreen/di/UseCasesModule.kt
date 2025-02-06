package com.example.forecast.screens.forcastScreen.di


import com.example.forcast.repositoriesDelegation.IForecastRepository
import com.example.forcast.usecase.getForecastListingUseCase.GetForecastListingUseCase
import com.example.forcast.usecase.getForecastListingUseCase.IGetForecastListingUseCase
import com.example.searchforweather.getCitiesFromQuery.GetCitiesFromQueryUseCase
import com.example.searchforweather.getCitiesFromQuery.IGetCitiesFromQueryUseCase
import com.example.searchforweather.repositories.ISearchForWeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    fun provideWeatherDetailsUseCase(forecastRepository: IForecastRepository): IGetForecastListingUseCase =
        GetForecastListingUseCase(forecastRepository)

}