package com.tsdev.data.source.local

import com.tsdev.data.Local
import com.tsdev.data.source.UserSearchHistory
import io.reactivex.Completable
import io.reactivex.Maybe
import tsthec.tsstudy.domain.model.DomainSearchUserHistory

interface StudyShipLocalRemoteDataSource : Local {
    fun loadUserSearchHistory(): Maybe<List<UserSearchHistory>>

    fun saveUserSearchHistory(keywords: UserSearchHistory): Completable

    fun removeUserSearchHistory(position: UserSearchHistory): Completable
}