package com.example.inputcityfeature

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.ForecastScreenRoute
import com.example.navigation.SearchScreen

fun NavGraphBuilder.inputCityRoute(navController: NavHostController) {
    composable<SearchScreen>{
        InputCityScreen{
            navController.navigate(ForecastScreenRoute(it.lat,it.lon))
        }
    }
}