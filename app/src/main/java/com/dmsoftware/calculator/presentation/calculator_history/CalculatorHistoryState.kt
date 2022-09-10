package com.dmsoftware.calculator.presentation.calculator_history

import com.dmsoftware.calculator.domain.model.Calculation

data class CalculatorHistoryState(
    val calculations: List<Calculation> = emptyList(),
)
