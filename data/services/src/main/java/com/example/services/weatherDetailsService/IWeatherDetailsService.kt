package com.example.services.weatherDetailsService

import io.ktor.client.statement.HttpResponse

interface IWeatherDetailsService {
    suspend fun getWeatherDetails(longitude: Double, latitude: Double): HttpResponse
}