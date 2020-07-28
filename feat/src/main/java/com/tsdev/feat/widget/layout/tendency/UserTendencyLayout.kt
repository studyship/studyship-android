package com.tsdev.feat.widget.layout.tendency

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatSeekBar

class UserTendencyLayout constructor(context: Context, attrs: AttributeSet) :
    AppCompatSeekBar(context, attrs) {
    init {
        max = 5
        progress = max / 2
    }
}