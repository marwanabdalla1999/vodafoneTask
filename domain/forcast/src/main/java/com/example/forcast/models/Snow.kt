package com.example.forcast.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Snow(
    @SerialName("3h")
    val h: Double
)