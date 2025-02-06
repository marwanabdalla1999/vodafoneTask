package com.example.forecast.di


import com.example.forcast.repositoriesDelegation.IForecastRepository
import com.example.forcast.usecase.getForecastListingUseCase.GetForecastListingUseCase
import com.example.forcast.usecase.getForecastListingUseCase.IGetForecastListingUseCase
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