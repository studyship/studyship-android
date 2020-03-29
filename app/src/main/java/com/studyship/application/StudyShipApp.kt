package com.studyship.application

import android.app.Application
import com.studyship.application.di.viewModel
import org.koin.core.context.startKoin

class StudyShipApp : Application() {
    override fun onCreate() {
        startKoin {
            modules(
                listOf(
                    viewModel
                )
            )
        }
        super.onCreate()
    }
}