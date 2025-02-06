package com.example.ui_models

import com.example.forcast.models.ForecastResponse
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

data class AppForecast(
    val cityName: String,
    val list: ImmutableList<AppForecastItem>
)

fun ForecastResponse.toAppForecast(): AppForecast = AppForecast(
    cityName = city.name,
    list = list.map { it.toAppForecastItem() }.toPersistentList()
)
