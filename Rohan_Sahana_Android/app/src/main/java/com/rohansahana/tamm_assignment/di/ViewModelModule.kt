package com.rohansahana.tamm_assignment.di

import androidx.lifecycle.ViewModel
import com.rohansahana.tamm_assignment.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@InstallIn(SingletonComponent::class)
@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun mainViewModel(mainViewModel: MainViewModel):ViewModel

}