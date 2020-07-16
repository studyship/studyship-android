package com.studyship.application.di

import com.studyship.application.setting.StringSharedPreference
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferenceModule = module {
    factory { (keyword: String) ->
        StringSharedPreference(
            androidContext().getSharedPreferences(
                keyword,
                0
            )
        )
    }
}