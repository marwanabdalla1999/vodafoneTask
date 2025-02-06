package com.example.forecast.screens.forcastScreen.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ui_models.AppForecast

@Composable
fun ForecastContent(appForecast: AppForecast, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        items(appForecast.list) {
            ForecastCard(forecast = it)
        }
    }
}