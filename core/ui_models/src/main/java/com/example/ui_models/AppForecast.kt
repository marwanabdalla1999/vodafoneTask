package com.example.ui_models

import com.example.forcast.models.ForecastResponse

data class AppForecast(
    val cityName: String,
    val list: List<AppForecastItem>
)

fun ForecastResponse.toAppForecast(): AppForecast = AppForecast(
    cityName = city.name,
    list = list.map { it.toAppForecastItem() }
)
