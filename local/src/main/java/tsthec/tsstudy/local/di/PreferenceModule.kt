package tsthec.tsstudy.local.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import tsthec.tsstudy.local.settings.UserSearchHistoryPreference

val preferenceModule = module {
    single { (sharedPreferenceKey: String) ->
        UserSearchHistoryPreference(
            androidContext().getSharedPreferences(
                sharedPreferenceKey,
                0
            )
        )
    }
}