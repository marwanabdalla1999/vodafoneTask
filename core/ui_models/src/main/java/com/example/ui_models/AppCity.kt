package com.example.ui_models

import com.example.searchforweather.entities.CitiesEntity

data class AppCity(
    val name: String,
    val lat: String,
    val lon: String,
    val country: String,
    val state: String

)

fun CitiesEntity.toCityModel(): AppCity {
    return AppCity(
        name = name,
        lat = lat,
        lon = lon,
        country = country,
        state = state
    )
}
