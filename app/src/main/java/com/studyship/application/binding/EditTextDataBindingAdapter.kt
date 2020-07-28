package com.studyship.application.binding

import android.view.MotionEvent
import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("isScrollable")
fun EditText.setScrollableBindingAdapter(isScrollable: Boolean) {
    if (isScrollable) {
        setOnTouchListener { view, motionEvent ->
            if (view.isFocusable) {
                view.parent.requestDisallowInterceptTouchEvent(true)
                when (motionEvent.action and MotionEvent.ACTION_MASK) {
                    MotionEvent.ACTION_UP -> {
                        view.performClick()
                        view.parent
                            .requestDisallowInterceptTouchEvent(false)
                    }
                }
            }
            false
        }
    }
}