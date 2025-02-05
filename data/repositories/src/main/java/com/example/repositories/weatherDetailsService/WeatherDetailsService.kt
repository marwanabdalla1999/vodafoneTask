package com.example.repositories.weatherDetailsService

import com.example.repositories.Constants
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class WeatherDetailsService(private val client: HttpClient) : IWeatherDetailsService {
    override suspend fun getWeatherDetails(longitude: Double, latitude: Double): HttpResponse {
        return client.get(Constants.WeatherDetails.PATH) {
            parameter(Constants.WeatherDetails.Parameters.LONGITUDE, longitude)
            parameter(Constants.WeatherDetails.Parameters.LATITUDE, latitude)
        }
    }
}