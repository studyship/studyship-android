package com.studyship.application

import android.app.Application
import com.studyship.application.di.categoryMapper
import com.studyship.application.di.customUiModule
import com.tsdev.data.di.repositoryModule
import com.tsdev.presentation.di.viewModelModule
import io.reactivex.plugins.RxJavaPlugins
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import tsthec.tsstudy.domain.di.useCaseModule
import tsthec.tsstudy.local.di.localDataSourceModule
import tsthec.tsstudy.local.di.preferenceModule

class StudyShipApp : Application() {
    override fun onCreate() {
        startKoin {
            androidContext(this@StudyShipApp)
            androidLogger()
            modules(
                listOf(
                    customUiModule,
                    categoryMapper,
                    localDataSourceModule,
                    repositoryModule,
                    preferenceModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }

        RxJavaPlugins.setErrorHandler {
            it.printStackTrace()
        }
        super.onCreate()
    }
}