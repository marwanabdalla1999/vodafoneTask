package com.example.repositories.cashingRepository

import com.example.repositories.cashingService.ICashingService
import com.example.searchforweather.repositories.ICashingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CashingRepository @Inject constructor(private val cashingService: ICashingService) :
    ICashingRepository {
    override fun getCashedLonAndLat(): Flow<Pair<Double?, Double?>> = flow {
        emit(cashingService.getCashedLonAndLat())
    }

    override suspend fun saveLonAndLat(lon: Double, lat: Double) {
        cashingService.saveLonAndLat(lon, lat)
    }
}