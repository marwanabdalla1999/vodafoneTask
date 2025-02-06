package com.example.navigation

import kotlinx.serialization.Serializable

@Serializable
object SearchScreen

@Serializable
data class ForecastScreen(val latitude: Double, val longitude: Double)
