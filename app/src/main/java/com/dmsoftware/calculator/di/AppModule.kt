package com.dmsoftware.calculator.di

import android.app.Application
import androidx.room.Room
import com.dmsoftware.calculator.data.local.CalculationDatabase
import com.dmsoftware.calculator.data.repository.CalculationRepositoryImpl
import com.dmsoftware.calculator.domain.repository.CalculationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCalculationDatabase(app: Application): CalculationDatabase {
        return Room.databaseBuilder(
            app,
            CalculationDatabase::class.java,
            CalculationDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCalculationRepository(db: CalculationDatabase): CalculationRepository {
        return CalculationRepositoryImpl(db.dao)
    }
}