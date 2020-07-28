package com.studyship.application.ui.widget.layout

import android.content.Context
import android.util.AttributeSet
import android.widget.HorizontalScrollView
import com.studyship.application.R

class HorizontalButtonLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defAttrs: Int = 0
) : HorizontalScrollView(context, attrs, defAttrs) {

    init {

        context.resources.getStringArray(R.array.sign_up_array).forEachIndexed { _, _ ->

        }
    }

}