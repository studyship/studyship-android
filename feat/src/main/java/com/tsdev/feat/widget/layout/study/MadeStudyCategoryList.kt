package com.tsdev.feat.widget.layout.study

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import com.tsdev.feat.R
import kotlinx.android.synthetic.main.layout_category_text_item.view.*
import tsthec.tsstudy.domain.model.DomainCategory
import tsthec.tsstudy.domain.model.DomainCategoryResponse

class MadeStudyCategoryList @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defAttribute: Int = 0
) : HorizontalScrollView(context, attributeSet, defAttribute) {
    private val HAS_CHILD = 1

    private val parentView = LinearLayout(context).apply {
        gravity = Gravity.CENTER
        orientation = LinearLayout.HORIZONTAL
    }

    fun setStudyCategoryList(studyCategories: List<DomainCategory>) {
        val studyCategoryViews = studyCategories.map {
            val studyView = LayoutInflater.from(context)
                .inflate(R.layout.layout_category_text_item, this, false)

            studyView.tv_category.text = it.categoryName

            studyView
        }

        studyCategoryViews.forEach(parentView::addView)



        if (childCount < HAS_CHILD) {
            addView(parentView)
        }
    }
}