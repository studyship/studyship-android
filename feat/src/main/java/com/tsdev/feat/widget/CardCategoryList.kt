package com.tsdev.feat.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.GridLayout
import com.tsdev.feat.R
import kotlinx.android.synthetic.main.layout_category_text_item.view.*

class CardCategoryList @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defAttr: Int = 0
) : GridLayout(context, attrs, defAttr) {

    init {
        columnCount = 3
    }

    fun setCategoryData(items: List<String>) {
        val categoryItems = items.map { categoryItem ->
            val item = LayoutInflater.from(context)
                .inflate(R.layout.layout_category_text_item, this, false)

            item.run {
                tv_category.text = categoryItem
            }
            item
        }

        categoryItems.forEach(::addView)
    }
}