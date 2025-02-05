package com.example.searchforweather.getCitiesFromQuery

import com.example.searchforweather.entities.CitiesEntity
import kotlinx.coroutines.flow.Flow

interface IGetCitiesFromQueryUseCase {
    suspend fun invoke(query: String): Flow<List<CitiesEntity>?>
}