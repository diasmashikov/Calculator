package com.dmsoftware.calculator.presentation.calculator_history

import AutoSizeText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dmsoftware.calculator.domain.model.Calculation

@Composable
fun CalculationItem(
    calculation: Calculation
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AutoSizeText(
            text = calculation.expression,
            fontSize = 12,
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(
            Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(color = MaterialTheme.colorScheme.onSurface)
                .padding(12.dp)
        ) {
            AutoSizeText(
                text = calculation.result,
                fontSize = 12,
                color = Color.White
            )
        }

    }
}