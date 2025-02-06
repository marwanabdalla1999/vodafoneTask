package com.example.inputcityfeature.di

import com.example.inputcityfeature.InputCityViewModel
import com.example.searchforweather.getCitiesFromQuery.IGetCitiesFromQueryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object ViewModelsModule {

    @Provides
    fun provideInputCityViewModel(getWeatherUseCase: IGetCitiesFromQueryUseCase): InputCityViewModel {
        return InputCityViewModel(getWeatherUseCase)
    }
}