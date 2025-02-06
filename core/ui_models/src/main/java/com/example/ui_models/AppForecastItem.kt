package com.example.ui_models

import com.example.forcast.models.ForecastItem

data class AppForecastItem(
    val weather: String,
    val temperature: String,
    val humidity: String,
    val windSpeed: String,
    val pressure: String,
    val weatherDescription: String,
    val weatherIconUrl: String
)

fun ForecastItem.toAppForecastItem(): AppForecastItem = AppForecastItem(
    weather = weather.firstOrNull()?.main ?: "",
    temperature = main?.temp.toString(),
    humidity = main?.humidity.toString(),
    windSpeed = wind?.speed.toString(),
    pressure = main?.pressure.toString(),
    weatherDescription = weather.firstOrNull()?.description ?: "",
    weatherIconUrl = "https://openweathermap.org/img/wn/${weather.firstOrNull()?.icon}@2x.png"
)
