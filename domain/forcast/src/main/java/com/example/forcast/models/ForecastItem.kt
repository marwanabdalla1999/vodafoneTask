package com.example.forcast.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastItem(
    @SerialName("clouds")
    val clouds: Clouds?,
    @SerialName("dt")
    val dt: Int?,
    @SerialName("dt_txt")
    val dtTxt: String?,
    @SerialName("main")
    val main: Main?,
    @SerialName("pop")
    val pop: Double?,
    @SerialName("rain")
    val rain: Rain?,
    @SerialName("snow")
    val snow: Snow?,
    @SerialName("sys")
    val sys: Sys?,
    @SerialName("visibility")
    val visibility: Int?,
    @SerialName("weather")
    val weather: List<Weather>,
    @SerialName("wind")
    val wind: Wind?
)