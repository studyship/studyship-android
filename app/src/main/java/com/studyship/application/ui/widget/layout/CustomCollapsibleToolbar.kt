package com.studyship.application.ui.widget.layout

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout

class CustomCollapsibleToolbar @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defAttributeSet: Int = 0
) : MotionLayout(context, attributeSet, defAttributeSet), AppBarLayout.OnOffsetChangedListener {
    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
    }
}