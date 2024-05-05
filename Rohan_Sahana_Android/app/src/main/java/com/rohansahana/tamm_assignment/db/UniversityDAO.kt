package com.rohansahana.tamm_assignment.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rohansahana.tamm_assignment.models.University

@Dao
interface UniversityDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUniversities(universities : List<University>)

    @Query("SELECT * FROM University")
    suspend fun getUniversities() : List<University>
}