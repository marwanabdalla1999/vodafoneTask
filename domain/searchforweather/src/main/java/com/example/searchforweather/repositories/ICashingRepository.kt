package com.example.searchforweather.repositories

import kotlinx.coroutines.flow.Flow

interface ICashingRepository {
    fun getCashedLonAndLat(): Flow<Pair<Double?, Double?>>
    suspend fun saveLonAndLat(lon: Double, lat: Double)
}