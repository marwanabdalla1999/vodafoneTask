package com.example.inputcityfeature


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchforweather.getCitiesFromQuery.IGetCitiesFromQueryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputCityViewModel @Inject constructor(private val getCitiesFromQueryUseCase: IGetCitiesFromQueryUseCase) :
    ViewModel() {
    private val _weatherResults = MutableStateFlow<List<CityModel>>(emptyList())
    val weatherResults: StateFlow<List<CityModel>> = _weatherResults

    private var searchWeatherJob: Job? = null

    fun searchWeather(query: String) {
        searchWeatherJob?.cancel()
        searchWeatherJob = viewModelScope.launch {
            delay(500)
            getCitiesFromQueryUseCase.invoke(query).collect { citiesEntity ->
                _weatherResults.value = citiesEntity?.map { it.toCityModel() } ?: emptyList()
            }
        }
    }
}