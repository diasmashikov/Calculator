package com.dmsoftware.calculator.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CalculationEntity(
    val expression: String,
    val result: String,
    @PrimaryKey val id: Int? = null
)