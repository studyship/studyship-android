package com.tsdev.feat.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.JustifyContent
import com.tsdev.data.source.Category
import com.tsdev.feat.R
import kotlinx.android.synthetic.main.layout_expanded_item.view.*

class ExpandedListAdapter @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defAttrSet: Int = 0
) : FlexboxLayout(context, attrs, defAttrSet) {
    init {
        flexDirection = FlexDirection.ROW
        justifyContent = JustifyContent.FLEX_START
    }

    fun setFlexItemLayout(items: List<Category>) {
        if (childCount > CHILD_COUNT) {
            removeAllViews()
        }
        val bottomSheetViewList = items.map { category ->
            val bottomSheet =
                LayoutInflater.from(context).inflate(R.layout.layout_expanded_item, this, false)

            bottomSheet.run {
                tv_bottom_sheet.text = category.categoryName
            }

            bottomSheet
        }

        bottomSheetViewList.forEach {
            addView(it)
        }

    }

    companion object {
        private const val CHILD_COUNT = 1
    }
}