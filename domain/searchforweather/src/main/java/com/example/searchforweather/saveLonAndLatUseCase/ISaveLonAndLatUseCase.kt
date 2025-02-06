package com.example.searchforweather.saveLonAndLatUseCase

interface ISaveLonAndLatUseCase {
    suspend operator fun invoke(lon: Double, lat: Double)
}