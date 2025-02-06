package com.example.inputcityfeature.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rabbit.core.base.SideEffectsKey


@Composable
fun InputCityScreen(
    viewModel: InputCityViewModel = hiltViewModel(),
    onCitySelected: (lon: String, lat: String) -> Unit
) {
    LaunchedEffect(SideEffectsKey) {
        viewModel.lonAndLat.collect {
            if (it != null) {
                onCitySelected(it.first.toString(), it.second.toString())
            }

        }
    }
    WeatherSearchContent(
        citiesState = viewModel.weatherResults,
        onCitySelected = {
            viewModel.saveLonAndLat(it.lon.toDoubleOrNull() ?: 0.0, it.lat.toDoubleOrNull() ?: 0.0)
            onCitySelected(it.lat, it.lon)
        }
    ) { query ->
        viewModel.searchWeather(query)
    }
}