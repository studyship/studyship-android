package com.studyship.application

import android.app.Application
import com.studyship.application.di.categoryMapper
import com.studyship.application.di.customUiModule
import com.studyship.application.di.preferenceModule
import com.tsdev.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tsthec.tsstudy.local.di.localDataSourceModule

class StudyShipApp : Application() {
    override fun onCreate() {
        startKoin {
            androidContext(this@StudyShipApp)
            modules(
                listOf(
                    viewModelModule,
                    customUiModule,
                    categoryMapper,
                    preferenceModule,
                    localDataSourceModule
                )
            )
        }
        super.onCreate()
    }
}