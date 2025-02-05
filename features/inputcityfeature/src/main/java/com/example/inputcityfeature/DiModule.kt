package com.example.inputcityfeature

import com.example.searchforweather.getCitiesFromQuery.IGetCitiesFromQueryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object ViewModelsModule {

    @Provides
    fun provideApiService(getWeatherUseCase: IGetCitiesFromQueryUseCase): InputCityViewModel {
        return InputCityViewModel(getWeatherUseCase)
    }
}