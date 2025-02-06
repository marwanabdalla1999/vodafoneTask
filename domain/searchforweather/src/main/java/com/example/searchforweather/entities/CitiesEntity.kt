package com.example.searchforweather.entities

import kotlinx.serialization.Serializable

@Serializable
data class CitiesEntity(
    val name: String,
    val lat: String,
    val lon: String,
    val country: String,
    val state: String
)