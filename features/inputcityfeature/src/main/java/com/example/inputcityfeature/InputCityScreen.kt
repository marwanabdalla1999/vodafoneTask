package com.example.inputcityfeature

import androidx.compose.runtime.Composable


@Composable
fun WeatherSearchScreen(viewModel: WeatherViewModel = hiltViewModel()){
    WeatherSearchContent(
        citiesState = viewModel.weatherResults
    ){ query ->
        viewModel.searchWeather(query)
    }
}