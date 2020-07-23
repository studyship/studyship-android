package com.tsdev.feat.widget.layout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.HorizontalScrollView

class HorizontalGatherDateLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defAttrs: Int = 0
) : HorizontalScrollView(context, attrs, defAttrs) {
    val userSelectedDate = mutableListOf<Pair<View, String>>()


}