package com.tsdev.feat.widget.layout

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import com.tsdev.feat.R
import com.tsdev.feat.widget.layout.base.BaseHorizontalScrollView
import kotlinx.android.synthetic.main.layout_user_select_date.view.*

class HorizontalUserSelectedView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defAttrs: Int = 0
) : BaseHorizontalScrollView(context, attrs, defAttrs) {

    init {
        cacheCategoryButtons.clear()
    }

    override val defaultParentView: LinearLayout by lazy {
        LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.START
        }
    }

    override fun setItemView(
        value: String,
        items: List<String>,
        position: Int,
        @LayoutRes layout: Int
    ): View {
        return LayoutInflater.from(context).inflate(layout, this, false)
            .apply {
                date_string.text = value
                if (items.size - 2 == position) {
                    tv_divide.visibility = View.VISIBLE
                } else {
                    tv_divide.visibility = View.GONE
                }
            }
    }

    override lateinit var setCategoryOnClickListener: OnCategoryClickListener
}