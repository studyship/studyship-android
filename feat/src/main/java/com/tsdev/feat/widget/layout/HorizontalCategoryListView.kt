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
import kotlinx.android.synthetic.main.layout_category_button.view.*

typealias OnCategoryClickListener = (Int) -> Unit

class HorizontalCategoryListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defAttrs: Int = 0
) : HorizontalScrollView(context, attrs, defAttrs) {

    lateinit var setCategoryOnClickListener: OnCategoryClickListener

    private lateinit var selectedView: View

    private val cacheCategoryButtons = mutableListOf<View>()

    private val defaultParentView: LinearLayout = LinearLayout(context).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.START
    }

    fun setCategory(names: List<String>) {
        if (cacheCategoryButtons.isEmpty()) {
            val customButtonView = names.mapIndexed { index, name ->
                val categoryButton =
                    LayoutInflater.from(context)
                        .inflate(R.layout.layout_category_button, this, false)
                categoryButton.setOnClickListener {
                    if (::selectedView.isInitialized) {
                        selectedView.isSelected = false
                    }
                    selectedView = it
                    it.isSelected = true
                    setCategoryOnClickListener(index)
                }
                categoryButton.run {
                    tv_category_name.text = name
                }
                cacheCategoryButtons.add(categoryButton)
                categoryButton
            }

            customButtonView.forEach(defaultParentView::addView)
        }

        if (childCount < HAS_CHILD) {
            addView(defaultParentView)
        }
    }

    fun initSelected() {
        cacheCategoryButtons[0].performClick()
    }

    companion object {
        private const val HAS_CHILD = 1
    }
}