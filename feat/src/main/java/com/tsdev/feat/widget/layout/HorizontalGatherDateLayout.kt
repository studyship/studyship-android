package com.tsdev.feat.widget.layout

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import com.tsdev.feat.R
import kotlinx.android.synthetic.main.layout_user_select_date.view.*

class HorizontalGatherDateLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defAttrs: Int = 0
) : HorizontalScrollView(context, attrs, defAttrs) {

    val userSelectedDate = mutableListOf<String>()

    private val defaultParentView: LinearLayout by lazy {
        LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.START
        }
    }

    fun setLayoutData(items: List<String>) {
        val dateLayouts = items.mapIndexed { position, value ->

            fun layoutItem(value: String): View {
                return LayoutInflater.from(context).inflate(
                    R.layout.layout_user_select_date,
                    this@HorizontalGatherDateLayout,
                    false
                ).apply {
                    date_string.text = value
                    setOnClickListener { view ->
                        userSelectedDate.getOrNull(position)?.run {
                            userSelectedDate.removeAt(userSelectedDate.indexOf(value))
                            view.isSelected = false
                        } ?: run {
                            userSelectedDate.add(value)
                            view.isSelected = true
                        }
                    }
                }
            }

            val button = layoutItem(value)

            button
        }
        dateLayouts.forEach(defaultParentView::addView)

        addView(defaultParentView)
    }

}