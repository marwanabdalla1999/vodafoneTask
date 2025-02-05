package com.example.inputcityfeature

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.StateFlow


@Composable
fun WeatherSearchContent(citiesState: StateFlow<List<CityModel>>, onSearch: (String) -> Unit) {
    var query by remember { mutableStateOf(TextFieldValue()) }
    val cities by citiesState.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
                onSearch(it.text)
            },
            label = { Text("Search for weather......") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(cities) { city ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = city.name,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}




