package com.example.repositories

object Constants {
    object WeatherDetails {
        const val PATH = "/data/2.5/weather"

        object Parameters {
            const val LONGITUDE = "lon"
            const val LATITUDE = "lat"
        }
    }

    object SearchForWeather {
        const val PATH = "/geo/1.0/direct?q="

        object Query {
            const val QUERY = "q"
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