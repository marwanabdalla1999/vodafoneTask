package com.example.forecast.screens.forcastScreen

import com.example.rabbit.core.base.ViewEvent
import com.example.rabbit.core.base.ViewSideEffect
import com.example.rabbit.core.base.ViewState
import com.example.ui_models.AppForecast

sealed interface ForecastEvent : ViewEvent {
    data class OnGetForecast(val latitude: Double, val longitude: Double) : ForecastEvent

}

sealed interface ForecastState : ViewState {
    data object Ideal : ForecastState
    data class Success(val forecast: AppForecast) : ForecastState
    data class Error(val message: Throwable) : ForecastState
    data object Loading : ForecastState
}

sealed interface ForecastSideEffect : ViewSideEffect {
    data class ShowToast(val message: String) : ForecastSideEffect
}