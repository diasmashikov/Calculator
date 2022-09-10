package com.dmsoftware.calculator.data.mapper

import com.dmsoftware.calculator.domain.model.Calculation
import com.dmsoftware.calculator.data.local.CalculationEntity

fun CalculationEntity.toCalculation(): Calculation {
    return Calculation(
        expression = expression,
        result = result
    )
}

fun Calculation.toCalculationEntity(): CalculationEntity {
    return CalculationEntity(
        expression = expression,
        result = result
    )
}