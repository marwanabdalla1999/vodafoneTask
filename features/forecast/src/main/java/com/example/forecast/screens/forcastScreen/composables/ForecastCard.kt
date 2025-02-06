package com.example.forecast.screens.forcastScreen.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.design.componants.asyncImage.RemoteImage
import com.example.design.componants.text.KeyAndValueText
import com.example.design.dimenions.Dimensions
import com.example.forecast.R
import com.example.ui_models.AppForecastItem

@Composable
fun ForecastCard(forecast: AppForecastItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .border(Dimensions.dp_1dp, Color.Black, RoundedCornerShape(Dimensions.dp_20dp))
            .padding(vertical = Dimensions.dp_10dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimensions.dp_10dp)
    ) {
        RemoteImage(url = forecast.weatherIconUrl)
        KeyAndValueText(key = stringResource(R.string.weather), value = forecast.weather)
        KeyAndValueText(
            key = stringResource(R.string.description),
            value = forecast.weatherDescription,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = Dimensions.dp_10dp)
        )

        ForecastRowData(
            firstKey = stringResource(R.string.temperature),
            firstValue = forecast.temperature,
            secondKey = stringResource(R.string.humidity),
            secondValue = forecast.humidity,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimensions.dp_10dp)
        )
        ForecastRowData(
            firstKey = stringResource(R.string.wind_speed),
            firstValue = forecast.windSpeed,
            secondKey = stringResource(R.string.pressure),
            secondValue = forecast.pressure,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimensions.dp_10dp)
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