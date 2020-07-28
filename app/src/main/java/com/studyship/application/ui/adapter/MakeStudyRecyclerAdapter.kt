package com.studyship.application.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.studyship.application.R
import com.studyship.application.base.BaseRecyclerViewAdapter
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.data.source.RecyclerItemSource
import com.studyship.application.ui.activity.createstudy.CreateStudyStepOneActivity
import com.studyship.application.ui.activity.TemporaryStudyActivity
import com.studyship.application.ui.adapter.holder.addstudy.MakeStudyRecyclerViewHolder
import com.studyship.application.ui.adapter.holder.addstudy.TemporaryStorageStudyRecyclerViewHolder
import com.studyship.application.util.comfortableStartActivity
import tsthec.tsstudy.domain.model.DomainMakeStudyResponse
import java.lang.IllegalArgumentException

class MakeStudyRecyclerAdapter : BaseRecyclerViewAdapter<RecyclerItemSource.RecyclerItem>() {

    private val makeStudyListItem = mutableListOf<RecyclerItemSource.RecyclerItem>()

    private val onMoveClickListener: (Context, String) -> Unit = { context, className ->
        when(className) {
            MAKE_STUDY_RECYCLER_VIEW_HOLDER_CLASSNAME -> {
                context.comfortableStartActivity<CreateStudyStepOneActivity>()
            }
            TEMPORARY_STORAGE_STUDY_RECYCLER_VIEW_HOLDER -> {
                context.comfortableStartActivity<TemporaryStudyActivity>()
            }
        }
    }

    override fun createBindingViewHolder(holder: BaseRecyclerViewHolder<*, *>, position: Int) {
        when (holder) {
            is MakeStudyRecyclerViewHolder -> {
                holder.setBindingMakeStudy(makeStudyListItem[position].item as DomainMakeStudyResponse)
            }
            is TemporaryStorageStudyRecyclerViewHolder -> {
                holder.setBindingMakeStudy(makeStudyListItem[position].item as DomainMakeStudyResponse)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, *> {
        return when (viewType) {
            CREATE_STUDY -> {
                MakeStudyRecyclerViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycler_item_make_study, parent, false),
                    onMoveClickListener
                )
            }
            TEMPORARY_STORAGE_STUDY -> {
                TemporaryStorageStudyRecyclerViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycler_item_temporary_study, parent, false),
                    onMoveClickListener
                )
            }
            else -> throw illegalException()
        }
    }

    override fun getItemCount(): Int = makeStudyListItem.size

    override fun getItemViewType(position: Int): Int {
        return makeStudyListItem[position].viewType
    }

    override fun addItem(viewType: Int, item: Any?) {
        makeStudyListItem.add(RecyclerItemSource.RecyclerItem(viewType, item))
    }

    override fun addItems(viewType: Int, itemList: List<Any>?) {
        itemList?.forEach {
            addItem(viewType, it)
        }
    }

    override fun destroyedEvent() {
        makeStudyListItem.clear()
    }

    override fun getItems(position: Int): Any? {
        return makeStudyListItem[position].item
    }

    override fun destroyedPositionItem(position: Int) {
        makeStudyListItem.removeAt(position)
    }

    @Throws(IllegalArgumentException::class)
    private fun illegalException(): Throwable {
        throw IllegalArgumentException("Missing viewType")
    }

    companion object {
        private const val CREATE_STUDY = 4000

        private const val TEMPORARY_STORAGE_STUDY = 4001

        private const val MAKE_STUDY_RECYCLER_VIEW_HOLDER_CLASSNAME = "MakeStudyRecyclerViewHolder"

        private const val TEMPORARY_STORAGE_STUDY_RECYCLER_VIEW_HOLDER = "TemporaryStorageStudyRecyclerViewHolder"
    }
}