package com.example.inputcityfeature.screens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.ForecastScreenRoute
import com.example.navigation.SearchScreen

fun NavGraphBuilder.inputCityRoute(navController: NavHostController) {
    composable<SearchScreen> {
        InputCityScreen { lon, lat ->
            navController.navigate(ForecastScreenRoute(lat, lon))
        }
    }
}