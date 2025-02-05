package com.example.inputcityfeature

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.SearchScreen

fun NavGraphBuilder.inputCityRoute(){
    composable<SearchScreen>{
        InputCityScreen{

        }
    }
}