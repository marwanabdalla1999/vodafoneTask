package com.example.forecast.screens.forcastScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.forecast.screens.forcastScreen.composables.ForecastContent
import com.example.rabbit.core.base.SideEffectsKey
import kotlinx.coroutines.flow.Flow

@Composable
fun ForecastScreen(
    latitude: Double,
    longitude: Double,
    state: ForecastState,
    onEventSent: (event: ForecastEvent) -> Unit,
    sideEffect: Flow<ForecastSideEffect>,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(SideEffectsKey) {
        sideEffect.collect {
            when (it) {
                is ForecastSideEffect.ShowToast -> TODO()
            }
        }
    }
    when (state) {
        is ForecastState.Error -> TODO()
        ForecastState.Ideal -> onEventSent(ForecastEvent.OnGetForecast(latitude, longitude))
        ForecastState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        is ForecastState.Success -> ForecastContent(appForecast = state.forecast)
    }

}