package com.example.searchforweather.repositories

import com.example.searchforweather.entities.CitiesEntity
import kotlinx.coroutines.flow.Flow


interface ISearchForWeatherRepository {

    suspend fun searchForWeather(query: String): Flow<List<CitiesEntity>?>
}