package com.rohansahana.tamm_assignment.repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rohansahana.tamm_assignment.db.UniversityDB
import com.rohansahana.tamm_assignment.models.University
import com.rohansahana.tamm_assignment.retrofit.UniversityAPI
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UniversityRepository @Inject constructor(
    private val universityAPI : UniversityAPI,
    private val universityDB: UniversityDB
) {
    private val _universities = MutableLiveData<List<University>>()
    val universities: LiveData<List<University>>
        get() = _universities

    suspend fun getUniversities() {
        try {
            Log.d(TAG, "Fetching universities from API")
            // Fetch data from API
            val result = universityAPI.getUniversities("United Arab Emirates")
            if (result.isSuccessful && result.body() != null) {
                Log.d(TAG, "API request successful: $result")
                // Add universities to the local database
                universityDB.getUniversityDAO().addUniversities(result.body()!!)
                // Update LiveData with the new list of universities
                _universities.postValue(result.body())
            } else {
                Log.d(TAG, "API request failed: $result")
                // If API request is not successful, fetch data from local database
                fetchFromLocalDatabase()
            }
        } catch (e: IOException) {
            Log.d(TAG, "Network error: ${e.message}")
            // If there's a network error, fetch data from local database
            fetchFromLocalDatabase()
        } catch (e: HttpException) {
            Log.d(TAG, "HTTP error: ${e.code()}")
            // If there's an HTTP error, fetch data from local database
            fetchFromLocalDatabase()
        }
    }

    private suspend fun fetchFromLocalDatabase() {
        Log.d(TAG, "Fetching universities from local database")
        // Fetch data from local database
        val fetchingDBData = universityDB.getUniversityDAO().getUniversities()
        if (fetchingDBData.isNotEmpty()) {
            Log.d(TAG, "Data fetched from local database: $fetchingDBData")
            // If data exists in local database, update LiveData with the cached data
            _universities.postValue(fetchingDBData)
        } else {
            Log.d(TAG, "No data available in local database $fetchingDBData")
            // If no data exists in local database, display an error
            _universities.postValue(emptyList())
        }
    }

    companion object {
        private const val TAG = "UniversityRepository"
    }
}