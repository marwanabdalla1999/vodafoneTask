package com.example.forecast.screens.forcastScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.beltone.homesand.coreDesign.designsystem.theme.dimenions.Dimensions
import com.example.design.componants.asyncImage.RemoteImage
import com.example.design.componants.text.KeyAndValueText
import com.example.forecast.R
import com.example.ui_models.AppForecastItem

@Composable
fun ForecastCard(forecast: AppForecastItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(Dimensions.dp_20dp))
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimensions.dp_10dp)
    ) {
        RemoteImage(url = forecast.weatherIconUrl)
        ForecastRowData(
            firstKey = stringResource(R.string.weather),
            firstValue = forecast.weather,
            secondKey = stringResource(R.string.description),
            secondValue = forecast.weatherDescription
        )
        ForecastRowData(
            firstKey = stringResource(R.string.temperature),
            firstValue = forecast.temperature,
            secondKey = stringResource(R.string.humidity),
            secondValue = forecast.humidity
        )
        ForecastRowData(
            firstKey = stringResource(R.string.wind_speed),
            firstValue = forecast.windSpeed,
            secondKey = stringResource(R.string.pressure),
            secondValue = forecast.pressure
        )
    }
}

@Composable
private fun ForecastRowData(
    firstKey: String,
    firstValue: String,
    secondKey: String,
    secondValue: String,
    modifier: Modifier = Modifier
) {
    Row(modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        KeyAndValueText(key = firstKey, value = firstValue)
        KeyAndValueText(key = secondKey, value = secondValue)
    }
}