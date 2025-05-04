package com.shashank.cointrackerapp.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.shashank.cointrackerapp.presentation.model.CoinUI
import com.shashank.cointrackerapp.presentation.model.DisplayNumber

@Composable
fun PriceChange(modifier: Modifier = Modifier, changePrice: DisplayNumber) {

    val textColor = if (changePrice.value > 0) Color.Green else Color.Red

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        Icon(
            imageVector = if (changePrice.value > 0) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            tint = textColor
        )
        Text(text = "${changePrice.formattedValue} %", color = textColor)
    }
}


@PreviewLightDark
@Composable
fun CoinPriceChangePreview() {
    PriceChange(changePrice = DisplayNumber(-12.9, "12.34"))
}