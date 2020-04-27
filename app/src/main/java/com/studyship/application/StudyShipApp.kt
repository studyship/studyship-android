package com.studyship.application

import android.app.Application
import com.studyship.application.di.viewModelModule
import org.koin.core.context.startKoin

class StudyShipApp : Application() {
    override fun onCreate() {
        startKoin {
            modules(
                listOf(
                    viewModelModule
                )
            )
        }
        super.onCreate()
    }
}