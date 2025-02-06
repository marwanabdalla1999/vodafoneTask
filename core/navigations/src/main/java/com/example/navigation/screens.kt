package com.example.navigation

import kotlinx.serialization.Serializable

@Serializable
object SearchScreen

@Serializable
data class ForecastScreenRoute(val latitude: String, val longitude: String)
