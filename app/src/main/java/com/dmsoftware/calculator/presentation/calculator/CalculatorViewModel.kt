package com.dmsoftware.calculator.presentation.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmsoftware.calculator.domain.CalculatorAction
import com.dmsoftware.calculator.domain.ExpressionWriter
import com.dmsoftware.calculator.domain.model.Calculation
import com.dmsoftware.calculator.domain.repository.CalculationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val repository: CalculationRepository
): ViewModel() {
    var expression by mutableStateOf("")
        private set
    private val writer: ExpressionWriter = ExpressionWriter()

    fun onAction(action: CalculatorAction) {
        writer.processAction(action)
        val oldExpression = this.expression
        this.expression = writer.expression
        if (action == CalculatorAction.Calculate) {
            viewModelScope.launch {
                repository.insertCalculation(
                    Calculation(
                        expression = oldExpression,
                        result = writer.expression
                    )
                )
            }
        }
    }
}