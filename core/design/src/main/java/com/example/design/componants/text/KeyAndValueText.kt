package com.example.design.componants.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.design.dimenions.Dimensions

@Composable
fun KeyAndValueText(
    key: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Dimensions.dp_10dp)
    ) {
        Text(text = key)
        Text(text = value, color = Color.Gray)
    }
}