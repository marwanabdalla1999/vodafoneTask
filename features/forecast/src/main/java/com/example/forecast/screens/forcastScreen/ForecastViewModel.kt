package com.example.forecast.screens.forcastScreen

import com.example.forcast.usecase.getForecastListingUseCase.IGetForecastListingUseCase
import com.example.rabbit.core.base.BaseViewModel
import com.example.ui_models.toAppForecast
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecastUseCase: IGetForecastListingUseCase
) : BaseViewModel<ForecastState, ForecastEvent, ForecastSideEffect>() {
    override fun setInitialState(): ForecastState = ForecastState.Ideal

    override fun handleEvents(event: ForecastEvent) {
        when (event) {
            is ForecastEvent.OnGetForecast -> getForecast(
                latitude = event.latitude,
                longitude = event.longitude
            )
        }
    }

    private fun getForecast(latitude: Double, longitude: Double) {
        getForecastUseCase(latitude = latitude, longitude = longitude).launchAndCollectResult(
            onStart = {
                setState { ForecastState.Loading }
            },
            onSuccess = {
                if (it != null)
                    setState { ForecastState.Success(it.toAppForecast()) }
                else
                    setState { ForecastState.Error(Throwable("No Data")) }
            },
            onError = {
                setState { ForecastState.Error(it) }
            }
        )
    }
}