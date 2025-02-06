package com.example.repositories.searchForWeatherRepository

import com.example.network.NetworkHelper
import com.example.repositories.searchForWeatherService.ISearchForWeatherService
import com.example.searchforweather.entities.CitiesEntity
import com.example.searchforweather.repositories.ISearchForWeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchForWeatherRepository @Inject constructor(
    private val searchForWeatherService: ISearchForWeatherService,
    private val networkHelper: NetworkHelper
) :
    ISearchForWeatherRepository {
    override suspend fun searchForWeather(query: String): Flow<List<CitiesEntity>?> = flow {

        val response = networkHelper.processCall<List<CitiesEntity>> {
            searchForWeatherService.searchForWeather(query)
        }
        emit(response)
    }
}