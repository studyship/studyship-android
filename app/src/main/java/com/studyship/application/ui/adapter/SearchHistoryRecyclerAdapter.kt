package com.studyship.application.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.studyship.application.R
import com.studyship.application.base.BaseRecyclerViewAdapter
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.data.source.RecyclerItemSource
import com.studyship.application.ui.adapter.holder.SearchHistoryRecyclerViewHolder
import com.studyship.application.ui.adapter.holder.SetOnClickRemoveListener
import com.tsdev.data.source.UserSearchHistory
import tsthec.tsstudy.domain.model.DomainSearchUserHistory
import tsthec.tsstudy.local.settings.UserSearchHistoryPreference

class SearchHistoryRecyclerAdapter : BaseRecyclerViewAdapter<RecyclerItemSource.RecyclerItem>() {

    private val searchHistoryItems = mutableListOf<RecyclerItemSource.RecyclerItem>()

    lateinit var setOnClickRemoveListener: SetOnClickRemoveListener

    override fun createBindingViewHolder(holder: BaseRecyclerViewHolder<*, *>, position: Int) {
        when (holder) {
            is SearchHistoryRecyclerViewHolder -> {
                holder.setBindingSearchHistory(searchHistoryItems[position].item as DomainSearchUserHistory)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, *> =
        when (viewType) {
            SEARCH_HISTORY_VIEW_TYPE -> {
                SearchHistoryRecyclerViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.recycler_search_history_item,
                        parent,
                        false
                    ),
                    setOnClickRemoveListener
                )
            }
            else -> throw IllegalAccessException()
        }


    override fun getItemCount(): Int = searchHistoryItems.size

    override fun addItem(viewType: Int, item: Any?) {
        searchHistoryItems.add(RecyclerItemSource.RecyclerItem(viewType, item))
    }

    fun isImplicateItem(searchKeyword: String?): Boolean {
        searchHistoryItems.forEach {
            if ((it.item as DomainSearchUserHistory).userKeywords == searchKeyword) {
                return true
            }
        }
        return false
    }

    fun setMoveItemAtFirstIndex(viewType: Int, item: Any?, searchKeyword: String) {
        fun getPosition(searchKeyword: String): Int {
            searchHistoryItems.forEachIndexed { index, recyclerItem ->
                if ((recyclerItem.item as DomainSearchUserHistory).userKeywords == searchKeyword) {
                    return index - 1
                }
            }
//            return searchHistoryItems.lastIndex
            return searchHistoryItems.lastIndex
        }

        val searchHistoryFirstData = searchHistoryItems[0]
        searchHistoryItems[0] = RecyclerItemSource.RecyclerItem(viewType, item)
        Log.e("POSITION", getPosition(searchKeyword).toString())
        searchHistoryItems[getPosition(searchKeyword)] = searchHistoryFirstData
    }

    override fun addItems(viewType: Int, itemList: List<Any>?) {
        itemList?.forEach {
            addItem(viewType, it)
        }
    }

    override fun destroyedEvent() {
        searchHistoryItems.clear()
    }

    override fun getItems(position: Int): Any? = searchHistoryItems[position].item

    override fun destroyedPositionItem(position: Int) {
        searchHistoryItems.removeAt(position)
        notifiedRemoveItemPosition(position)
    }

    override fun getItemViewType(position: Int): Int {
        return searchHistoryItems[position].viewType
    }

    companion object {
        const val SEARCH_HISTORY_VIEW_TYPE = 1000
    }
}