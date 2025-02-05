package com.example.repositories.searchForWeatherService

import com.example.repositories.Constants
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import javax.inject.Inject

internal class SearchForWeatherService @Inject constructor(private val client: HttpClient) :
    ISearchForWeatherService {
    override suspend fun searchForWeather(query: String): HttpResponse {
        return client.get(Constants.SearchForWeather.PATH) {
            parameter(Constants.SearchForWeather.Query.QUERY, query)
        }
    }
}