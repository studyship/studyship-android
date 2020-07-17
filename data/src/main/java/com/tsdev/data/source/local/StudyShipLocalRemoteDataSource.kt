package com.tsdev.data.source.local

import com.tsdev.data.Local

interface StudyShipLocalRemoteDataSource : Local {
    fun loadUserSearchHistory(): List<String>

    fun saveUserSearchHistory(keywords: String)
}