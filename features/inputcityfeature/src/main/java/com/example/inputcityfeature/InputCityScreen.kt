package com.example.inputcityfeature

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun InputCityScreen(viewModel: InputCityViewModel = hiltViewModel(), onCitySelected: (CityModel) -> Unit){
    WeatherSearchContent(
        citiesState = viewModel.weatherResults
    ){ query ->
        viewModel.searchWeather(query)
    }
}