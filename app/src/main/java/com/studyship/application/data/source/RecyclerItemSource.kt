package com.studyship.application.data.source

sealed class RecyclerItemSource {
    data class RecyclerItem(val viewType: Int, val item: Any?): RecyclerItemSource()
}