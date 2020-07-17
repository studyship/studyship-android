package tsthec.tsstudy.local.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import tsthec.tsstudy.local.settings.SEARCH_HISTORY
import tsthec.tsstudy.local.settings.UserSearchHistoryPreference

val preferenceModule = module {
    factory {
        UserSearchHistoryPreference(
            androidContext().getSharedPreferences(
                SEARCH_HISTORY,
                0
            )
        )
    }
}