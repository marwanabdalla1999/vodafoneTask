package com.example.repositories.diModules

import com.example.repositories.searchForWeatherService.ISearchForWeatherService
import com.example.repositories.searchForWeatherService.SearchForWeatherService
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
}