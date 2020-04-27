package com.studyship.application.ui.widget

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
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

fun spotlightBuilder(activity: Activity, targets: List<Target>) =
    Spotlight.Builder(activity)
        .setBackgroundColor(R.color.selected_bottom_navigation_color)
        .setDuration(SPOTLIGHT_DURATION)
        .setTargets(targets)
        .setAnimation(DecelerateInterpolator(ANIMATION_FACTOR))

fun targetBuilder(layoutInflater: LayoutInflater, frameLayout: FrameLayout, idRes: View) =
    Target.Builder()
        .setAnchor(idRes)
        .setOverlay(layoutInflater.inflate(R.layout.target_layout, frameLayout))
        .setShape(Circle(SHAPE_VALUE))
        .build()