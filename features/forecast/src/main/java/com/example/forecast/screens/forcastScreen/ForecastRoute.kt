package com.example.forecast.screens.forcastScreen

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.navigation.ForecastScreenRoute


fun NavGraphBuilder.forecastRoute(
    navController: NavHostController
) {
    composable<ForecastScreenRoute>{
        val viewModel = hiltViewModel<ForecastViewModel>()
        val latitude  = it.toRoute<ForecastScreenRoute>().latitude
        val longitude = it.toRoute<ForecastScreenRoute>().longitude
        ForecastScreen(
            latitude = latitude.toDouble(),
            longitude = longitude.toDouble(),
            state = viewModel.viewState.collectAsStateWithLifecycle().value,
            onEventSent = viewModel::setEvent,
            sideEffect = viewModel.effect,
        )
    }
}