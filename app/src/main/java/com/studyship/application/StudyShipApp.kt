package com.studyship.application

import android.app.Application
import com.studyship.application.di.customUiModule
import com.studyship.application.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StudyShipApp : Application() {
    override fun onCreate() {
        startKoin {
            androidContext(this@StudyShipApp)
            modules(
                listOf(
                    viewModelModule,
                    customUiModule
                )
            )
        }
        super.onCreate()
    }
}