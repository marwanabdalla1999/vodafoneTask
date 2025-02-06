package com.example.searchforweather.getCashedLonAndLatUseCase

import com.example.searchforweather.repositories.ICashingRepository
import javax.inject.Inject

class GetCashedLonAndLatUseCase @Inject constructor(private val cashingRepository: ICashingRepository) :
    IGetCashedLonAndLatUseCase {
    override operator fun invoke() = cashingRepository.getCashedLonAndLat()
}