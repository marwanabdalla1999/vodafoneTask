package com.example.repositories.cashingService

import androidx.datastore.preferences.core.doublePreferencesKey
import com.example.cashing.DataStoreManager
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class CashingService @Inject constructor(private val dataStoreManager: DataStoreManager) :
    ICashingService {
    override suspend fun getCashedLonAndLat(): Pair<Double?, Double?> {
        return dataStoreManager.getData(lon, null).firstOrNull() to
                dataStoreManager.getData(lat, null).firstOrNull()

    }

    override suspend fun saveLonAndLat(lon: Double, lat: Double) {
        dataStoreManager.saveData(key = CashingService.lon, value = lon)
        dataStoreManager.saveData(key = CashingService.lat, value = lat)
    }

    companion object {
        private val lon = doublePreferencesKey("lon")
        private val lat = doublePreferencesKey("lat")
    }
}