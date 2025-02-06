package com.example.inputcityfeature

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ui_models.AppCity


@Composable
fun InputCityScreen(
    viewModel: InputCityViewModel = hiltViewModel(),
    onCitySelected: (AppCity) -> Unit
) {
    WeatherSearchContent(
        citiesState = viewModel.weatherResults,
                onCitySelected = onCitySelected
    ){ query ->
        viewModel.searchWeather(query)
    }
}