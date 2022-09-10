package com.dmsoftware.calculator.presentation

import com.dmsoftware.calculator.domain.model.Calculation
import com.dmsoftware.calculator.domain.repository.CalculationRepository
import com.dmsoftware.calculator.util.Resource
import kotlinx.coroutines.flow.Flow

class FakeCalculationRepository : CalculationRepository {
    override fun getCalculations(): Flow<Resource<List<Calculation>>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertCalculation(calculation: Calculation) {
        TODO("Not yet implemented")
    }
}