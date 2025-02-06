package com.example.searchforweather.getCashedLonAndLatUseCase

import kotlinx.coroutines.flow.Flow

interface IGetCashedLonAndLatUseCase {
    operator fun invoke(): Flow<Pair<Double?, Double?>>
}