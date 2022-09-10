package com.dmsoftware.calculator.presentation.calculator_history

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmsoftware.calculator.domain.repository.CalculationRepository
import com.dmsoftware.calculator.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CalculatorHistoryViewModel @Inject constructor(
    private val repository: CalculationRepository
): ViewModel() {
    var state by mutableStateOf(CalculatorHistoryState())
        private set

    init {
        getCalculations()
    }

    private fun getCalculations() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCalculations()
                .collect { result ->
                    when(result) {
                        is Resource.Success -> {
                            withContext(Dispatchers.Main) {
                                result.data?.let { calculations ->
                                    state = state.copy(
                                        calculations = calculations
                                    )
                                }
                            }
                        }
                        is Resource.Error -> {

                        }
                    }
                }
        }
    }

}