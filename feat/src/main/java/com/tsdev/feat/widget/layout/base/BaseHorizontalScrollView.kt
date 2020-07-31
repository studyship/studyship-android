package com.tsdev.feat.widget.layout.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import com.tsdev.feat.widget.layout.OnCategoryClickListener

abstract class BaseHorizontalScrollView(
    context: Context,
    attrs: AttributeSet,
    defAttrs: Int
) : HorizontalScrollView(context, attrs, defAttrs) {
    abstract val defaultParentView: LinearLayout

    internal val cacheCategoryButtons = mutableListOf<View>()

    abstract var setCategoryOnClickListener: OnCategoryClickListener

    lateinit var selectedView: View

    private val HAS_CHILD = 1

    fun setLayoutData(items: List<String>, @LayoutRes layout: Int) {
        if (cacheCategoryButtons.isEmpty()) {
            val customButtonView = items.mapIndexed { position, values ->
                val itemView = setItemView(values, items, position, layout)
                itemView.setOnClickListener {
                    if (::selectedView.isInitialized) {
                        selectedView.isSelected = false
                    }
                    selectedView = it
                    it.isSelected = true
                    setCategoryOnClickListener(position)
                }

                cacheCategoryButtons.add(itemView)

                itemView
            }
            customButtonView.forEach(defaultParentView::addView)
        }

        if (childCount < HAS_CHILD) {
            addView(defaultParentView)
        }
    }


    abstract fun setItemView(
        value: String,
        items: List<String>,
        position: Int,
        @LayoutRes layout: Int
    ): View

}