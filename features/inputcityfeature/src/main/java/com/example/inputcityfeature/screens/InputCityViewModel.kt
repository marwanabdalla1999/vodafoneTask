package com.example.inputcityfeature.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchforweather.getCashedLonAndLatUseCase.IGetCashedLonAndLatUseCase
import com.example.searchforweather.getCitiesFromQuery.IGetCitiesFromQueryUseCase
import com.example.searchforweather.saveLonAndLatUseCase.ISaveLonAndLatUseCase
import com.example.ui_models.AppCity
import com.example.ui_models.toCityModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputCityViewModel @Inject constructor(
    private val getCitiesFromQueryUseCase: IGetCitiesFromQueryUseCase,
    private val saveLonAndLatUseCase: ISaveLonAndLatUseCase,
    private val getCashedLonAndLatUseCase: IGetCashedLonAndLatUseCase
) :
    ViewModel() {
    private val _weatherResults = MutableStateFlow<List<AppCity>>(emptyList())
    val weatherResults: StateFlow<List<AppCity>> = _weatherResults

    private val _lonAndLat = Channel<Pair<Double, Double>?>()
    val lonAndLat: Flow<Pair<Double, Double>?> = _lonAndLat.receiveAsFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }
    private var searchWeatherJob: Job? = null

    init {
        getCashedLonAndLat()
    }

    fun saveLonAndLat(lon: Double, lat: Double) {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            saveLonAndLatUseCase.invoke(lon, lat)
        }
    }

    private fun getCashedLonAndLat() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            getCashedLonAndLatUseCase.invoke().collect {
                if (it.first != null && it.second != null) {
                    _lonAndLat.send(Pair(it.first!!, it.second!!))
                }
            }

        }
    }

    fun searchWeather(query: String) {
        searchWeatherJob?.cancel()
        searchWeatherJob = viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            delay(200)
            getCitiesFromQueryUseCase.invoke(query).collect { citiesEntity ->
                _weatherResults.value = citiesEntity?.map { it.toCityModel() } ?: emptyList()
            }
        }
    }
}