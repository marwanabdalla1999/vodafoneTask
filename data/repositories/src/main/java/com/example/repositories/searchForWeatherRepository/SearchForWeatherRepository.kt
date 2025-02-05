package com.example.repositories.searchForWeatherRepository

import com.example.repositories.searchForWeatherService.ISearchForWeatherService
import com.example.searchforweather.entities.CitiesEntity
import com.example.searchforweather.repositories.ISearchForWeatherRepository
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchForWeatherRepository @Inject constructor(private val searchForWeatherService: ISearchForWeatherService) :
    ISearchForWeatherRepository {
    override suspend fun searchForWeather(query: String): Flow<List<CitiesEntity>?> = flow {
        val response = searchForWeatherService.searchForWeather(query)
            .body<List<SearchForWeatherResponseItem>?>()
        emit(response?.map { it.toCitiesEntity() })
    }
}