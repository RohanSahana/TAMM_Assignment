package com.rohansahana.tamm_assignment.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rohansahana.tamm_assignment.models.University
import com.rohansahana.tamm_assignment.typeconverters.Converters

@Database(entities = [University::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class UniversityDB : RoomDatabase() {

    abstract fun getUniversityDAO(): UniversityDAO

}
