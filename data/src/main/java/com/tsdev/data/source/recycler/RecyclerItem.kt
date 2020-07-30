package com.tsdev.data.source.recycler

sealed class RecyclerSource {
    data class RecyclerViewPagerItem(val viewType: Int, val item: Any?) : RecyclerSource()
}