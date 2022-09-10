package com.dmsoftware.calculator.data.repository

import com.dmsoftware.calculator.data.mapper.toCalculation
import com.dmsoftware.calculator.data.mapper.toCalculationEntity
import com.dmsoftware.calculator.domain.repository.CalculationRepository
import com.dmsoftware.calculator.domain.model.Calculation
import com.dmsoftware.calculator.util.Resource
import com.dmsoftware.calculator.data.local.CalculationDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CalculationRepositoryImpl(
    private val dao: CalculationDao
) : CalculationRepository {
    override fun getCalculations(): Flow<Resource<List<Calculation>>> {
        return flow {
            val localCalculations = dao.getCalculations()
            emit(Resource.Success(
                data = localCalculations.map {
                    it.toCalculation()
                }
            ))
        }
    }

    override suspend fun insertCalculation(calculation: Calculation) {
       dao.insertCalculation(calculation.toCalculationEntity())
    }
}