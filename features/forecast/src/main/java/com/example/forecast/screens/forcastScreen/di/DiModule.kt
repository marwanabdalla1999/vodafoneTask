package com.example.forecast.screens.forcastScreen.di

import com.example.forcast.usecase.getForecastListingUseCase.IGetForecastListingUseCase
import com.example.forecast.screens.forcastScreen.ForecastViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object ViewModelsModule {

    @Provides
    fun provideForecastViewModel(getForecastUseCase: IGetForecastListingUseCase): ForecastViewModel {
        return ForecastViewModel(getForecastUseCase)
    }
}