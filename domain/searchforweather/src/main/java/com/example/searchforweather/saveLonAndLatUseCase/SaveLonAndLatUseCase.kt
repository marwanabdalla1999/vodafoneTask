package com.example.searchforweather.saveLonAndLatUseCase

import com.example.searchforweather.repositories.ICashingRepository
import javax.inject.Inject

class SaveLonAndLatUseCase @Inject constructor(private val cashingRepository: ICashingRepository) :
    ISaveLonAndLatUseCase {
    override suspend operator fun invoke(lon: Double, lat: Double) {
        cashingRepository.saveLonAndLat(lon, lat)
    }

}