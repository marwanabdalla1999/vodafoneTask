package com.example.forecast.screens.forcastScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ForecastRoute(
    latitude: Double,
    longitude: Double,
    modifier: Modifier = Modifier,
    viewModel: ForecastViewModel = hiltViewModel()
) {
    ForecastScreen(
        latitude = latitude,
        longitude = longitude,
        state = viewModel.viewState.collectAsStateWithLifecycle().value,
        onEventSent = viewModel::setEvent,
        sideEffect = viewModel.effect,
    )
}