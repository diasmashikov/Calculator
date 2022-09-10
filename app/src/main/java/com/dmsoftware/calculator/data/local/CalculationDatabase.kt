package com.dmsoftware.calculator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CalculationEntity::class],
    version = 1
)
abstract class CalculationDatabase: RoomDatabase() {
    abstract val dao: CalculationDao

    companion object {
        const val DATABASE_NAME = "calculator_db"
    }
}