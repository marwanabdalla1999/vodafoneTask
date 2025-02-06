package com.example.vodafonetask.di


import com.example.forcast.repositoriesDelegation.IForecastRepository
import com.example.forcast.usecase.getForecastListingUseCase.GetForecastListingUseCase
import com.example.forcast.usecase.getForecastListingUseCase.IGetForecastListingUseCase
import com.example.searchforweather.getCashedLonAndLatUseCase.GetCashedLonAndLatUseCase
import com.example.searchforweather.getCashedLonAndLatUseCase.IGetCashedLonAndLatUseCase
import com.example.searchforweather.getCitiesFromQuery.GetCitiesFromQueryUseCase
import com.example.searchforweather.getCitiesFromQuery.IGetCitiesFromQueryUseCase
import com.example.searchforweather.repositories.ICashingRepository
import com.example.searchforweather.repositories.ISearchForWeatherRepository
import com.example.searchforweather.saveLonAndLatUseCase.ISaveLonAndLatUseCase
import com.example.searchforweather.saveLonAndLatUseCase.SaveLonAndLatUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    fun provideWeatherDetailsUseCase(forecastRepository: IForecastRepository): IGetForecastListingUseCase =
        GetForecastListingUseCase(forecastRepository)

    @Provides
    fun provideCitiesFromQueryUseCase(getWeatherRepository: ISearchForWeatherRepository): IGetCitiesFromQueryUseCase {
        return GetCitiesFromQueryUseCase(getWeatherRepository)
    }

    @Provides
    fun provideGetCashedLonAndLatUseCase(cashingRepository: ICashingRepository): IGetCashedLonAndLatUseCase {
        return GetCashedLonAndLatUseCase(cashingRepository)
    }

    @Provides
    fun provideSaveLonAndLatUseCase(cashingRepository: ICashingRepository): ISaveLonAndLatUseCase {
        return SaveLonAndLatUseCase(cashingRepository)
    }

}