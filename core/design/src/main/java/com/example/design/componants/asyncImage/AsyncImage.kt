package com.example.design.componants.asyncImage

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.example.design.dimenions.Dimensions


@Composable
fun RemoteImage(
    url: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.FillBounds,
    shape: Shape? = RoundedCornerShape(Dimensions.dp_20dp),
    alignment: Alignment = Alignment.Center,
    isLoading: Boolean = false
) {
    AsyncImage(
        modifier = if (shape == null) modifier else modifier.clip(shape),
        model = if (isLoading) null else url,
        contentDescription = null,
        contentScale = contentScale,
        alignment = alignment,
        filterQuality = FilterQuality.High,
    )

}
