package com.example.vodafonetask

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.forecast.screens.forcastScreen.forecastRoute
import com.example.inputcityfeature.screens.inputCityRoute
import com.example.navigation.SearchScreen


@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController, startDestination = SearchScreen
    ) {
        inputCityRoute(navController)
        forecastRoute(navController)
    }

}