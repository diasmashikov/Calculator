package com.dmsoftware.calculator.domain.repository

import com.dmsoftware.calculator.domain.model.Calculation
import com.dmsoftware.calculator.util.Resource
import kotlinx.coroutines.flow.Flow

interface CalculationRepository {
    fun getCalculations(): Flow<Resource<List<Calculation>>>

    suspend fun insertCalculation(calculation: Calculation)
}