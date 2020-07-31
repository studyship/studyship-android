package com.tsdev.feat.widget.layout

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.feat.R
import com.tsdev.feat.widget.layout.base.BaseHorizontalScrollView
import kotlinx.android.synthetic.main.layout_category_button.view.*
import kotlinx.android.synthetic.main.recycler_my_study_item.view.*

typealias OnCategoryClickListener = (Int) -> Unit

class HorizontalCategoryListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defAttrs: Int = 0
) : BaseHorizontalScrollView(context, attrs, defAttrs) {

    init {
        cacheCategoryButtons.clear()
    }

    override lateinit var setCategoryOnClickListener: OnCategoryClickListener

    override fun setItemView(
        value: String,
        items: List<String>,
        position: Int,
        @LayoutRes layout: Int
    ): View {
        return LayoutInflater.from(context)
            .inflate(layout, this, false).apply {
                when (layout) {
                    R.layout.layout_user_select_date -> {
                        tv_category_name.text = value
                    }
                    R.layout.recycler_my_study_item -> {
                        filter_title.text = value
                        filter_count.text = "5"
                    }
                }

            }
    }

    override val defaultParentView: LinearLayout = LinearLayout(context).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.START
    }

    fun initSelected() {
        cacheCategoryButtons[0].performClick()
    }
}