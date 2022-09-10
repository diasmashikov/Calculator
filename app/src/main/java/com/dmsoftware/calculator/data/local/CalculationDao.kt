package com.dmsoftware.calculator.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CalculationDao {

    @Query("SELECT * FROM calculationentity")
    fun getCalculations(): List<CalculationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCalculation(
        calculationEntity: CalculationEntity
    )


}