package com.example.repositories.cashingService

interface ICashingService {
    suspend fun getCashedLonAndLat(): Pair<Double?, Double?>

    suspend fun saveLonAndLat(lon: Double, lat: Double)
}