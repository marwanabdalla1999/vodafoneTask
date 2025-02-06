package com.example.forecast.screens.forcastScreen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.design.dimenions.Dimensions
import com.example.ui_models.AppForecast

@Composable
fun ForecastContent(appForecast: AppForecast, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(Dimensions.dp_16dp),
        verticalArrangement = Arrangement.spacedBy(Dimensions.dp_16dp)
    ) {
        items(appForecast.list) {
            ForecastCard(forecast = it, modifier = Modifier.fillMaxWidth())
        }
    }
}