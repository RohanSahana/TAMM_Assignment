package com.rohansahana.tamm_assignment.di

import android.content.Context
import androidx.room.Room
import com.rohansahana.tamm_assignment.db.UniversityDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideUniversityDB(context : Context): UniversityDB{
        return Room.databaseBuilder(context, UniversityDB::class.java, "UniversityDB").build()
    }
}