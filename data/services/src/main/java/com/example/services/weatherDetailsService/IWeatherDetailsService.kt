package com.example.services.weatherDetailsService

import io.ktor.client.statement.HttpResponse

interface IWeatherDetailsService {
    suspend fun getWeatherDetails(longitude: Double, latitude: Double): HttpResponse
    suspend fun getForecastDetails(longitude: Double, latitude: Double): HttpResponse
}