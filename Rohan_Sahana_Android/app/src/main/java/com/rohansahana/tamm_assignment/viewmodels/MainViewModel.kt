package com.rohansahana.tamm_assignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohansahana.tamm_assignment.models.University
import com.rohansahana.tamm_assignment.repository.UniversityRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: UniversityRepository) : ViewModel() {

    val universityLiveData : LiveData<List<University>>
        get() = repository.universities

    init {
        viewModelScope.launch {
            repository.getUniversities()
        }
    }
}