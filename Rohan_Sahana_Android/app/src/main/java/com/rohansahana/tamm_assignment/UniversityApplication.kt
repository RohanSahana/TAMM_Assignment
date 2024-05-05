package com.rohansahana.tamm_assignment

import android.app.Application
import com.rohansahana.tamm_assignment.di.ApplicationComponent
import com.rohansahana.tamm_assignment.di.DaggerApplicationComponent
import dagger.Component


class UniversityApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}