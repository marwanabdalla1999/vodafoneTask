package com.example.repositories.weatherDetailsService

import io.ktor.client.statement.HttpResponse

interface IWeatherDetailsService {
    suspend fun getWeatherDetails(longitude: Double, latitude: Double): HttpResponse
}