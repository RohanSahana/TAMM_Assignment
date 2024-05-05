package com.rohansahana.tamm_assignment.retrofit

import com.rohansahana.tamm_assignment.models.University
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityAPI {

    @GET("search")
    suspend fun getUniversities(@Query("country") country: String): Response<List<University>>


}