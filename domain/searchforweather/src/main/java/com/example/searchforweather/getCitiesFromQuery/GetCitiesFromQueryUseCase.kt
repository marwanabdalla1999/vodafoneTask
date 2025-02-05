package com.example.searchforweather.getCitiesFromQuery

import com.example.searchforweather.entities.CitiesEntity
import com.example.searchforweather.repositories.ISearchForWeatherRepository
import kotlinx.coroutines.flow.Flow

class GetCitiesFromQueryUseCase(private val searchForWeatherRepository: ISearchForWeatherRepository) :
    IGetCitiesFromQueryUseCase {

    override suspend fun invoke(query: String): Flow<List<CitiesEntity>?> =
        searchForWeatherRepository.searchForWeather(query)

}