package com.example.yana.spinnerhome.data.ui

import android.app.Application
import com.example.yana.spinnerhome.data.di.saveModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationSpinner: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationSpinner)
            saveModules
        }
    }
}