package com.example.repositories.diModules

import com.example.repositories.searchForWeatherRepository.SearchForWeatherRepository
import com.example.repositories.searchForWeatherService.ISearchForWeatherService
import com.example.searchforweather.repositories.ISearchForWeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Provides
    fun provideSearchForWeatherRepository(searchForWeatherService: ISearchForWeatherService): ISearchForWeatherRepository {
        return SearchForWeatherRepository(searchForWeatherService)
    }
}