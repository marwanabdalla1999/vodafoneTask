package com.example.vodafonetask

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.inputcityfeature.WeatherSearchScreen


@Composable
fun AppNavHost(navController: NavHostController) {
        NavHost(navController, startDestination = "search") {
            composable("search") { WeatherSearchScreen() }

        }
    }