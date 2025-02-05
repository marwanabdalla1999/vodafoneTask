package com.example.services

object Constants {
    object WeatherDetails {
        const val PATH = "/data/2.5/weather"

        object Parameters {
            const val LONGITUDE = "lon"
            const val LATITUDE = "lat"
        }
    }

    object ForecastDetails {
        const val PATH = "/data/2.5/forecast"

        object Parameters {
            const val LONGITUDE = "lon"
            const val LATITUDE = "lat"
        }
    }
}