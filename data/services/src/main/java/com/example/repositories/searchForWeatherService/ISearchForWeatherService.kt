package com.example.repositories.searchForWeatherService

import io.ktor.client.statement.HttpResponse

interface ISearchForWeatherService {

    suspend fun searchForWeather(query: String): HttpResponse
}