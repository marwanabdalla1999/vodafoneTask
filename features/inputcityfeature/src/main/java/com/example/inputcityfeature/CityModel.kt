package com.example.inputcityfeature

import com.example.searchforweather.entities.CitiesEntity

data class CityModel(
    val name: String,
    val lat: String,
    val lon: String,
    val country: String,
    val state: String

)

fun CitiesEntity.toCityModel(): CityModel {
    return CityModel(
        name = name,
        lat = lat,
        lon = lon,
        country = country,
        state = state
    )
}
