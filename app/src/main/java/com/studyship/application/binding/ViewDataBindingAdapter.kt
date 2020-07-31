package com.studyship.application.binding

import android.view.View
import android.view.animation.AnimationUtils
import androidx.databinding.BindingAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.studyship.application.R

@BindingAdapter("isVisible")
fun View.setVisibleDataBindingAdapter(textLength: Int?) {
    visibility = if (textLength == 0) {
        View.VISIBLE
    } else {
        View.GONE
    }

}

@BindingAdapter("getInputText")
fun View.setInVisibleBindingAdapter(userInputText: String?) {
    visibility = if (userInputText.isNullOrEmpty()) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("finishAdapter")
fun View.setFinishBindingAdapter(finish: View.OnClickListener) {
    finish.onClick(this)
}

@BindingAdapter("isFabButtonAnimated")
fun FloatingActionButton.setVisibleFabButtonBindingAdapter(isAnimated: Boolean) {
    val anim = AnimationUtils.loadAnimation(context, R.anim.fade_in)

    animation = anim
    
    if (isAnimated) {
        anim.start()
    }
}