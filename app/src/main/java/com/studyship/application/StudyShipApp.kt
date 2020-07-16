package com.studyship.application

import android.app.Application
import com.studyship.application.di.categoryMapper
import com.studyship.application.di.customUiModule
//import com.studyship.application.di.viewModelModule
import com.tsdev.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StudyShipApp : Application() {
    override fun onCreate() {
        startKoin {
            androidContext(this@StudyShipApp)
            modules(
                listOf(
                    viewModelModule,
                    customUiModule,
                    categoryMapper
                )
            )
        }
        super.onCreate()
    }
}