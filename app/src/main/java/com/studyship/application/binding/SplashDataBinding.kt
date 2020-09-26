package com.studyship.application.binding

import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.studyship.application.R

@BindingAdapter("delayDuration", "threadCallback")
fun ImageView.setBindingSplashDelayActivity(delay: Long, callback: () -> Unit) {
    animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)

    Handler().postDelayed(callback, delay)
}