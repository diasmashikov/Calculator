package com.dmsoftware.calculator.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmsoftware.calculator.presentation.calculator_history.CalculationItem
import com.dmsoftware.calculator.presentation.calculator_history.CalculatorHistoryViewModel

@Composable
fun CalculatorHistoryScreen(
    onComposing: (AppBarState) -> Unit,
    viewModel: CalculatorHistoryViewModel = hiltViewModel()
) {
    val state = viewModel.state

    LaunchedEffect(key1 = true) {
        onComposing(
            AppBarState(
                title = "Calculator History",
            )
        )
    }

    LazyColumn(
    ) {
        items(state.calculations) { calculation ->
            CalculationItem(calculation = calculation)
        }
    }
}
