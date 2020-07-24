package com.tsdev.feat.widget.layout

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.feat.R
import com.tsdev.feat.widget.layout.base.BaseHorizontalScrollView
import kotlinx.android.synthetic.main.layout_category_button.view.*

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

    override fun setItemView(value: String, items: List<String>, position: Int): View {
        return LayoutInflater.from(context)
            .inflate(R.layout.layout_category_button, this, false).apply {
                tv_category_name.text = value
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