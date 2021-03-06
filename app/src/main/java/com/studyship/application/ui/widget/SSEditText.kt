package com.studyship.application.ui.widget

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.marginEnd
import com.studyship.application.R

class SSEditText : AppCompatEditText {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defAttr: Int) : super(
        context,
        attrs,
        defAttr
    )

    init {
        background = context.getDrawable(R.drawable.custom_edit_text_bg)
        maxLines = 1
    }

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)

        background = if (focused) {
            context.getDrawable(R.drawable.custom_edit_text_focus_bg)
        } else {
            context.getDrawable(R.drawable.custom_edit_text_bg)
        }
    }
}