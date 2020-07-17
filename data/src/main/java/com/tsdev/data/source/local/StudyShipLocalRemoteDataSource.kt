package com.tsdev.data.source.local

import com.tsdev.data.Local
import io.reactivex.Completable
import io.reactivex.Maybe

interface StudyShipLocalRemoteDataSource : Local {
    fun loadUserSearchHistory(): Maybe<List<String>>

    fun saveUserSearchHistory(keywords: String): Completable
}