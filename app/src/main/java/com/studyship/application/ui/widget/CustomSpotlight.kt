package com.studyship.application.ui.widget

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.annotation.IdRes
import com.studyship.application.R
import com.takusemba.spotlight.OnTargetListener
import com.takusemba.spotlight.Spotlight
import com.takusemba.spotlight.Target
import com.takusemba.spotlight.shape.Circle


private const val SPOTLIGHT_DURATION = 1000L
private const val ANIMATION_FACTOR = 2f
private const val SHAPE_VALUE = 150f

fun spotlightBuilder(activity: Activity, @IdRes vararg view: Int = IntArray(0)) =
    Spotlight.Builder(activity)
        .setBackgroundColor(R.color.selected_bottom_navigation_color)
        .setDuration(SPOTLIGHT_DURATION)
        .setAnimation(DecelerateInterpolator(ANIMATION_FACTOR))

fun targetBuilder(context: Context, idRes: View) = Target.Builder()
    .setAnchor(idRes)
    .setOverlay()
    .setShape(Circle(SHAPE_VALUE))
    .setOnTargetListener(object : OnTargetListener {
        override fun onEnded() {
            Toast.makeText(context, "onEnded called", Toast.LENGTH_LONG).show()
        }

        override fun onStarted() {
            Toast.makeText(context, "onStarted called", Toast.LENGTH_LONG).show()
        }

    })