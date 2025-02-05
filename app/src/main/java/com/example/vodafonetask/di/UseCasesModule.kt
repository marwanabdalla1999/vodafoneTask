package com.example.vodafonetask.di

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
    fun provideCitiesFromQueryUseCase(getWeatherRepository: ISearchForWeatherRepository): IGetCitiesFromQueryUseCase {
        return GetCitiesFromQueryUseCase(getWeatherRepository)
    }
}